package lotto.domain;

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

    private static List<Integer> makeLottoNumberBasket() {
        List<Integer> nums = new ArrayList<>();
        for (int i = LottoNo.MIN_NUMBER; i <= LottoNo.MAX_NUMBER; i++) {
            nums.add(i);
        }
        return nums;
    }

    public static StatisticsResult winningStatistics(List<LottoTicket> lottoTickets, WinningLottoTicket winningLottoTicket) {
        StatisticsResult statisticsResult = new StatisticsResult();

        for (LottoTicket lottoTicket : lottoTickets) {
            statisticsResult.increaseTypeCount(winningLottoTicket.isWinning(lottoTicket));
        }

        return statisticsResult;
    }

}
