package lotto.service;

import lotto.domain.*;
import lotto.domain.strategy.AutoBuyingStrategy;
import lotto.domain.strategy.BuyingStrategy;
import lotto.domain.strategy.ManualBuyingStrategy;

import java.util.*;

public class LottoLogic {

    public static List<LottoTicket> buyLottoTickets(PurchaseList purchaseList) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        AutoBuyingStrategy autoBuyingStrategy = new AutoBuyingStrategy(purchaseList);
        ManualBuyingStrategy manualBuyingStrategy = new ManualBuyingStrategy(purchaseList);

        lottoTickets.addAll(buyTicket(manualBuyingStrategy));
        lottoTickets.addAll(buyTicket(autoBuyingStrategy));

        return lottoTickets;
    }

    private static List<LottoTicket> buyTicket(BuyingStrategy buyingStrategy) {
        return buyingStrategy.buyTicket();
    }

    public static StatisticsResult winningStatistics(List<LottoTicket> lottoTickets, WinningLottoNos winningLottoNos) {
        StatisticsResult statisticsResult = new StatisticsResult();

        for (LottoTicket lottoTicket : lottoTickets) {
            statisticsResult.increaseTypeCount(winningLottoNos.rankWinning(lottoTicket));
        }

        return statisticsResult;
    }

}
