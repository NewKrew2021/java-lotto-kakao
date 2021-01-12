package lotto.domain;

import java.util.*;

public class LottoLogic {

    private static Money money;

    public static List<LottoTicket> buyLottoTicketsAuto(int inputMoney) {
        money = new Money(inputMoney);
        List<LottoTicket> lottoTickets = new ArrayList<>();
        List<Integer> numberBasket = makeLottoNumberBasket();

        while(money.payForTicket()) {
            Collections.shuffle(numberBasket);
            lottoTickets.add(new LottoTicket(numberBasket.subList(0, LottoTicket.LOTTO_NUMBER_COUNT_OF_TICKET)));
        }

        return lottoTickets;
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
