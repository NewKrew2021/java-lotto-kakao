package lotto.view;

import lotto.domain.ranking.LottoRanking;

import java.util.Map;

public class OutputView {
    private static final String NEW_LINE = System.lineSeparator();
    public static final String WINNING_STATISTICS_MESSAGE = "당첨 통계";
    public static final String LINE_DIVIDE_MESSAGE = "---------";

    public static void printTicketCount(int ticketCount) {
        System.out.printf("%d개를 구매했습니다.%s", ticketCount, NEW_LINE);
    }

    public static void printTicketNumbers(LottoNumbersDto lottoNumbers) {
        System.out.println(lottoNumbers.getSortedLottoNumbers());
    }


    public static void printWinningStatistics(LottoRankingCountDto lottoRankingCount) {
        System.out.println(WINNING_STATISTICS_MESSAGE);
        System.out.println(LINE_DIVIDE_MESSAGE);
        for (Map.Entry<LottoRanking, Integer> entry : lottoRankingCount.getRankingCount().entrySet()) {
            System.out.printf("%s %d개%s", entry.getKey().getContext(), entry.getValue(), NEW_LINE);
        }
    }

    public static void printRevenueRate(double revenueRate) {
        System.out.printf("총 수익률은 %.2f입니다.", revenueRate);
    }

}
