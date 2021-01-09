package lotto.domain;

import java.util.*;

import lotto.input.BuyingMoneyValidInputGuaranteer;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class LottoLogic {
    static LottoInputView inputView;

    static {
        inputView = new LottoInputView();
    }

    public void play() {
        int lottoCount = inputView.getLottoCountFromUser();
        List<LottoNos> tickets = makeRandomLottos(lottoCount);
        LottoOutputView.printLottoCount(tickets);

        StatisticsResult result = LottoLogic.winningStatistics(tickets,
                new WinningLottoNos(
                        inputView.inputWinningNumbers(),
                        inputView.inputBonusNumber()));
        System.out.println(result.toString());
        System.out.println(result.benefit(tickets.size()));
    }

    private static List<LottoNos> makeRandomLottos(int howmany) {
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

    public static StatisticsResult winningStatistics(List<LottoNos> lottoTickets, WinningLottoNos winningLottoNos) {
        StatisticsResult statisticsResult = new StatisticsResult();

        for (LottoNos lottoNos : lottoTickets) {
            statisticsResult.increaseTypeCount(winningLottoNos.isWinning(lottoNos));
        }
        return statisticsResult;
    }

}
