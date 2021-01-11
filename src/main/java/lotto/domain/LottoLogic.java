package lotto.domain;

import java.util.*;

import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class LottoLogic {
    static LottoInputView inputView;

    static {
        inputView = new LottoInputView();
    }

    public void play() {
        int lottoCount = inputView.getLottoCountFromUser();
        List<LottoNumbers> tickets = makeRandomLottos(lottoCount);
        LottoOutputView.printLottoCount(tickets);

        StatisticsResult result = LottoLogic.winningStatistics(tickets,
                new WinningLottoNos(
                        inputView.inputWinningNumbers(),
                        inputView.inputBonusNumber()));
        System.out.println(result.toString());
        System.out.println(result.benefit(tickets.size()));
    }

    private static List<LottoNumbers> makeRandomLottos(int howmany) {
        List<LottoNumbers> lottoTickets = new ArrayList<>();
        List<Integer> nums = makeLottoNumber();
        for (int i = 0; i < howmany; i++) {
            Collections.shuffle(nums);
            lottoTickets.add(new LottoNumbers(nums.subList(0, 6)));
        }
        return lottoTickets;
    }

    private static List<Integer> makeLottoNumber() {
        List<Integer> nums = new ArrayList<>();
        for (int i = LottoNumber.MIN_NUMBER; i <= LottoNumber.MAX_NUMBER; i++) {
            nums.add(i);
        }
        return nums;
    }

    public static StatisticsResult winningStatistics(List<LottoNumbers> lottoTickets, WinningLottoNos winningLottoNos) {
        StatisticsResult statisticsResult = new StatisticsResult();

        for (LottoNumbers lottoNumbers : lottoTickets) {
            statisticsResult.increaseTypeCount(winningLottoNos.getMatchResult(lottoNumbers));
        }
        return statisticsResult;
    }

}
