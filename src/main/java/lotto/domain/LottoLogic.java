package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class LottoLogic {
    static LottoInputView inputView;

    static {
        inputView = new LottoInputView();
    }

    public void play() {
        List<LottoNumbers> totalTickets = getTotalTickets();
        LottoOutputView.printLottoCount(totalTickets);

        StatisticsResult result = LottoLogic.winningStatistics(totalTickets,
                new WinningLottoNos(
                        inputView.inputWinningNumbers(),
                        inputView.inputBonusNumber()));
        System.out.println(result.toString());
        System.out.println(result.benefit(totalTickets.size()));
    }

    private List<LottoNumbers> getTotalTickets(){
        int totalLottoCount = inputView.getLottoCountFromUser();
        List<LottoNumbers> selfTickets = inputView.getSelfTickets(inputView.inputSelfLottoCount());
        List<LottoNumbers> exceptSelfTickets = makeRandomTickets(totalLottoCount - selfTickets.size());
        List<LottoNumbers> totalTickets = Stream.concat(selfTickets.stream(), exceptSelfTickets.stream())
                .collect(Collectors.toList());
        return totalTickets;
    }

    private static List<LottoNumbers> makeRandomTickets(int howmany) {
        List<LottoNumbers> lottoTickets = new ArrayList<>();
        List<Integer> nums = makeLottoNumber();
        for (int i = 0; i < howmany; i++) {
            Collections.shuffle(nums);
            lottoTickets.add(new LottoNumbers(nums.subList(0, LottoNumbers.LOTTO_NUMBER_COUNT_IN_ONE_TICKET)));
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
