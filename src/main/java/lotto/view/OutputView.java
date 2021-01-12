package lotto.view;

import lotto.controller.LottoController;
import lotto.domain.ranking.LottoRanking;

import java.util.Map;

public class OutputView {
    private static final String NEW_LINE = System.lineSeparator();
    public static final String WINNING_STATISTICS_MESSAGE = "당첨 통계";
    public static final String LINE_DIVIDE_MESSAGE = "---------";
    public static final String INPUT_MANUAL_NUMBERS_MESSAGE = "수동으로 구매할 번호를 입력해주세요.";

    public static void printTicketCount(int manualTicketCount, int autoTicketCount) {
        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.%s", manualTicketCount, autoTicketCount, NEW_LINE);
    }

    public static void printInputManualNumbers() {
        System.out.println(INPUT_MANUAL_NUMBERS_MESSAGE);
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

    public static void printAllTickets(LottoController lottoController) {
        for (int i = 0; i < lottoController.getNumOfAllTickets(); i++) {
            System.out.println(lottoController.getSortedLottoNumbers(i));
        }
    }

}
