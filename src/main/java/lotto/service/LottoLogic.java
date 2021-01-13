package lotto.service;

import lotto.domain.*;

import java.util.*;

public class LottoLogic {

    private static Money money;
    private static AutoBuyingStrategy autoBuyingStrategy = new AutoBuyingStrategy();

    public static List<LottoTicket> buyLottoTicketsAuto(int inputMoney) {
        money = new Money(inputMoney);
        List<LottoTicket> lottoTickets = new ArrayList<>();


        while(money.payForTicket()) {
            lottoTickets.add(buyTicket(autoBuyingStrategy));
        }

        return lottoTickets;
    }

    private static LottoTicket buyTicket(BuyingStrategy buyingStrategy) {
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
