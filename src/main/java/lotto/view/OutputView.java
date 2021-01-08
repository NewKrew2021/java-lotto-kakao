package lotto.view;

import lotto.domain.game.LottoRevenueRate;
import lotto.domain.game.LottoTicketCount;
import lotto.domain.ranking.LottoRanking;

import java.util.Map;

public class OutputView {

    private static final String NEW_LINE = System.lineSeparator();

    public static void printTicketCount(LottoTicketCount ticketCount) {
        System.out.printf("%d개를 구매했습니다.%s", ticketCount.getTicketCount(), NEW_LINE);
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
