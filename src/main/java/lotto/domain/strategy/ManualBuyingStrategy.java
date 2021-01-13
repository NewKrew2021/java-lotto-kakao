package lotto.domain.strategy;

import lotto.domain.LottoNo;
import lotto.domain.LottoTicket;
import lotto.domain.PurchaseList;

import java.util.*;

public class ManualBuyingStrategy implements BuyingStrategy{

    private PurchaseList purchaseList;

    public ManualBuyingStrategy(PurchaseList purchaseList) {
        this.purchaseList = purchaseList;
    }

    @Override
    public List<LottoTicket> buyTicket() {
        List<LottoTicket> autoLottoTickets = new ArrayList<>();

        while(this.purchaseList.payForManualTicketing()) {
            autoLottoTickets.add(new LottoTicket(purchaseList.getManualTicketNumbers()));
        }

        return autoLottoTickets;
    }

}
