package lotto.domain;

import lotto.domain.strategy.AutoBuyingStrategy;
import lotto.domain.strategy.BuyingStrategy;
import lotto.domain.strategy.ManualBuyingStrategy;
import lotto.exception.WrongMoneyInputException;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BuyingList {

    private int autoTicketCount;
    private int manualTicketCount;

    public BuyingList(int money, List<Set<Integer>> manualLottoTicketNumbers) {
        if( !validateInputMoney(money) ) {
            throw new WrongMoneyInputException();
        }

        this.manualTicketCount = manualLottoTicketNumbers.size();
        this.autoTicketCount = money / LottoTicket.LOTTO_PRICE - manualTicketCount;
    }

    public BuyingList(BuyingListDto buyingListDto) {
        this(buyingListDto.getMoney(), buyingListDto.getManualLottoNumbers());
    }

    public static boolean validateInputMoney(final int money) {
        return money >= LottoTicket.LOTTO_PRICE;
    }

    public boolean payForAutoTicketing() {
        if( this.autoTicketCount <= 0 ) {
            return false;
        }
        this.autoTicketCount -= 1;
        return true;
    }

    public boolean payForManualTicketing() {
        if( this.manualTicketCount <= 0 ) {
            return false;
        }
        this.manualTicketCount -= 1;
        return true;
    }

    public int getAutoTicketCount() {
        return autoTicketCount;
    }

    public int getManualTicketCount() {
        return manualTicketCount;
    }

    public List<LottoTicket> buyAllTickets(BuyingListDto buyingListDto) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        AutoBuyingStrategy autoBuyingStrategy = new AutoBuyingStrategy();
        ManualBuyingStrategy manualBuyingStrategy = new ManualBuyingStrategy(buyingListDto);

        while(payForAutoTicketing()) {
            lottoTickets.add(buyTicket(autoBuyingStrategy));
        }
        while(payForManualTicketing()) {
            lottoTickets.add(buyTicket(manualBuyingStrategy));
        }

        return lottoTickets;
    }

    private LottoTicket buyTicket(BuyingStrategy buyingStrategy) {
        return buyingStrategy.buyTicket();
    }
}
