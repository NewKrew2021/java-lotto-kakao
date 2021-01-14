package lotto.view;

import lotto.domain.LottoGame;
import lotto.domain.RankState;
import lotto.domain.UserBuyNumbers;
import lotto.dto.LottoStatisticDTO;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OutputView {

    private static final String BUY_COUNT_OUTPUT_MESSAGE = "수동으로 %d장, 자동으로 %d장을 구매했습니다.\n";

    private static final String STATISTIC_TITLE = "당첨 통계";
    private static final String HORIZON_LINE_TYPE = "-";
    private static final int HORIZON_LINE_LENGTH = 10;

    private static final String RANK_COUNT_OUTPUT_MESSAGE = "%d개 일치 (%d원)- %d개\n";
    private static final String SECOND_RANK_COUNT_OUTPUT_MESSAGE = "%d개 일치, 보너스 볼 일치 (%d원)- %d개\n";
    private static final String PROFIT_RATE_OUTPUT_MESSAGE = "총 수익률은 %.2f 입니다.\n";

    public static void printLottoCount(int manualCount, LottoGame lottoGame) {
        System.out.printf(BUY_COUNT_OUTPUT_MESSAGE, manualCount, lottoGame.getLottoCount() - manualCount);
    }

    public static void printBuyLotto(UserBuyNumbers userBuyNumbers) {
        System.out.println(userBuyNumbers.toString());
        System.out.println();
    }

    public static void printResult(LottoStatisticDTO lottoStatisticDTO) {
        System.out.println(STATISTIC_TITLE);
        System.out.println(String.join("", Collections.nCopies(HORIZON_LINE_LENGTH, HORIZON_LINE_TYPE)));
        printRankCount(lottoStatisticDTO.getRankCount());
        printProfitRate(lottoStatisticDTO.getProfitRate());
    }

    private static void printRankCount(List<Integer> rankCounts) {
        Arrays.stream(RankState.values())
                .filter(rank -> rank != RankState.FAIL)
                .forEach(rank -> printEachRankCount(rank, rankCounts.get(rank.getRankIndex())));
    }

    private static void printEachRankCount(RankState rankState, int rankCount) {
        if (rankState == RankState.SECOND) {
            System.out.printf(SECOND_RANK_COUNT_OUTPUT_MESSAGE,
                    rankState.getMatchCount(), rankState.getWinMoney(), rankCount);
            return;
        }
        System.out.printf(RANK_COUNT_OUTPUT_MESSAGE,
                rankState.getMatchCount(), rankState.getWinMoney(), rankCount);
    }

    private static void printProfitRate(double profitRate) {
        System.out.printf(PROFIT_RATE_OUTPUT_MESSAGE, profitRate);
    }
}
