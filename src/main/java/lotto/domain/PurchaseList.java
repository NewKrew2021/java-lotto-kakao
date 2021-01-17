package lotto.domain;

import lotto.domain.strategy.AutoBuyingStrategy;
import lotto.domain.strategy.BuyingStrategy;
import lotto.domain.strategy.ManualBuyingStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class PurchaseList {

    private int autoTicketCount;
    private int manualTicketCount;

    public PurchaseList(int money) {
        if( !validateInputMoney(money) ) {
            throw new IllegalArgumentException("잘못된 금액을 입력하셨습니다.");
        }

        this.autoTicketCount = money / 1000;
    }

    public PurchaseList(int money, List<Set<Integer>> manualLottoTicketNumbers) {
        if( !validateInputMoney(money) ) {
            throw new IllegalArgumentException("잘못된 금액을 입력하셨습니다.");
        }

        this.manualTicketCount = manualLottoTicketNumbers.size();
        this.autoTicketCount = money / 1000 - manualTicketCount;
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

    public List<LottoTicket> buyAllTickets(LottoDto lottoDto) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        AutoBuyingStrategy autoBuyingStrategy = new AutoBuyingStrategy();
        ManualBuyingStrategy manualBuyingStrategy = new ManualBuyingStrategy(lottoDto);

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
