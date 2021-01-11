package lotto.view;

import lotto.domain.game.LottoRevenueRate;
import lotto.domain.game.LottoTicketCounts;
import lotto.domain.ranking.LottoRanking;

import java.util.Map;

public class OutputView {

    private static final String NEW_LINE = System.lineSeparator();

    public static void printTicketCounts(LottoTicketCounts ticketCounts) {
        System.out.printf("수동으로 %d장, 자동으로 %d장 구매했습니다.%s",
                ticketCounts.getManualCount(), ticketCounts.getAutoCount(), NEW_LINE);
    }

    public static void printTicketNumbers(LottoNumbersDto lottoNumbers) {
        System.out.println(lottoNumbers.getLottoNumbers());
    }

    public static void printWinningStatistics(LottoStatisticsDto lottoRankingCount) {
        StringBuilder sb = new StringBuilder();
        sb.append("당첨 통계")
                .append(NEW_LINE)
                .append("---------")
                .append(NEW_LINE);
        for (Map.Entry<LottoRanking, Long> entry : lottoRankingCount.getRankingCount().entrySet()) {
            sb.append(entry.getKey().getContext())
                    .append(entry.getValue())
                    .append(NEW_LINE);
        }
        System.out.println(sb.toString());
    }

    public static void printRevenueRate(LottoRevenueRate revenueRate) {
        System.out.printf("총 수익률은 %.2f입니다.", revenueRate.getRate());
    }
}
