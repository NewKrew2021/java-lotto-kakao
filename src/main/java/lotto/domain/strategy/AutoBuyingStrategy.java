package lotto.domain.strategy;

import lotto.domain.LottoNo;
import lotto.domain.LottoTicket;
import lotto.domain.PurchaseList;

import java.util.*;

public class AutoBuyingStrategy implements BuyingStrategy{

    private PurchaseList purchaseList;

    public AutoBuyingStrategy(PurchaseList purchaseList) {
        this.purchaseList = purchaseList;
    }

    @Override
    public List<LottoTicket> buyTicket() {
        List<LottoTicket> autoLottoTickets = new ArrayList<>();

        while(this.purchaseList.payForAutoTicketing()) {
            Collections.shuffle(LottoNo.lottoNumberBasket);
            autoLottoTickets.add(new LottoTicket(new HashSet<>(LottoNo.lottoNumberBasket.subList(0, LottoTicket.LOTTO_NUMBER_COUNT_OF_TICKET))));
        }

        return autoLottoTickets;
    }
}
