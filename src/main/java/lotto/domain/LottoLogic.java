package lotto.domain;

import java.util.*;

public class LottoLogic {

    public static List<LottoTicket> buyLottoTicketsAuto(int count) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        List<Integer> nums = makeLottoNumber();
        for (int i = 0; i < count; i++) {
            Collections.shuffle(nums);
            lottoTickets.add(new LottoTicket(nums.subList(0, 6)));
        }
        return lottoTickets;
    }

    private static List<Integer> makeLottoNumber() {
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            nums.add(i);
        }
        return nums;
    }

    public static StatisticsResult winningStatistics(List<LottoTicket> lottoTickets, WinningLottoNos winningLottoNos ) {
        StatisticsResult statisticsResult = new StatisticsResult();

        for (LottoTicket lottoTicket : lottoTickets) {
            statisticsResult.increaseTypeCount(winningLottoNos.isWinning(lottoTicket));
        }
        return statisticsResult;
    }

}
