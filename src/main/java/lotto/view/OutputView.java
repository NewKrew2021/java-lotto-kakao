package lotto.view;

import lotto.domain.*;

import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class OutputView {
    public static final String SELF_LOTTO_NUMBER_INPUT_TEXT = "수동으로 구매할 번호를 입력해 주세요.";
    public static final String BUY_SUCCESS_TEXT = "수동으로 %d개, 자동으로 %d개를 구매했습니다.\n";
    public static final String STATISTICS_LINE_TEXT = "당첨 통계\n---------";
    public static final String ALL_PROFIT_TEXT = "총 수익률은 %d%% 입니다.\n";
    public static final String RANK_TEXT_HEAD = "%d개 일치";
    public static final String RANK_TEXT_ONLY_SECOND = ", 보너스 볼 일치";
    public static final String RANK_TEXT_TAIL = " (%d원) - %d개\n";
    public static final String JOIN_DELIMITER = ", ";
    public static final String CLOSE_BRACKET = "]";
    public static final String OPEN_BRACKET = "[";

    public static void printSelfLottoNumberInputGuide() {
        System.out.println(SELF_LOTTO_NUMBER_INPUT_TEXT);
    }

    public static void printLottoCount(int selfLottoCount, int randomLottoCount) {
        System.out.printf(BUY_SUCCESS_TEXT, selfLottoCount, randomLottoCount);
    }

    public static void printLottos(Lottos lottos) {
        List<Set<LottoNumber>> lottosDto = lottos.getLottosData();
        for (Set<LottoNumber> lotto : lottosDto) {
            System.out.println(getLottoText(lotto));
        }
    }

    private static String getLottoText(Set<LottoNumber> lotto) {
        return OPEN_BRACKET + lotto.stream().map(LottoNumber::getNumber)
                .map(lottoNumber -> Integer.toString(lottoNumber))
                .collect(Collectors.joining(JOIN_DELIMITER)) + CLOSE_BRACKET;
    }

    public static void printStatistics(Statistics statistics) {
        System.out.println(STATISTICS_LINE_TEXT);
        printRaffleResult(statistics);
        System.out.printf(ALL_PROFIT_TEXT, statistics.getProfitRate());
    }

    private static void printRaffleResult(Statistics statistics) {
        StringBuilder sb = new StringBuilder();
        Rank.stream()
                .filter(rank -> rank != Rank.BOOM)
                .forEach(rank -> {
                    sb.append(String.format(RANK_TEXT_HEAD,
                            rank.getMatchCount()));
                    if (rank == Rank.SECOND) {
                        sb.append(RANK_TEXT_ONLY_SECOND);
                    }
                    sb.append(String.format(RANK_TEXT_TAIL, rank.getReward(),
                            statistics.getCountOfRank(rank)));
                });
        System.out.println(sb);
    }
}
