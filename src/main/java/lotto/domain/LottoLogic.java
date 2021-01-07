package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoLogic {

    public static List<LottoNos> makeRandomLottos(int howmany) {
        List<LottoNos> lottoTickets = new ArrayList<>();
        List<Integer> nums = makeLottoNumber();
        for (int i = 0; i < howmany; i++) {
            Collections.shuffle(nums);
            lottoTickets.add(new LottoNos(nums.subList(0, 6)));
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

    public static StatisticsResult winningStatistics(List<LottoNos> lottoTickets, WinningLottoNos winningLottoNos ) {
        StatisticsResult statisticsResult = new StatisticsResult();

        for (LottoNos lottoNos: lottoTickets) {
            statisticsResult.increaseTypeCount(winningLottoNos.isWinning(lottoNos));
        }
        return statisticsResult;
    }

}
