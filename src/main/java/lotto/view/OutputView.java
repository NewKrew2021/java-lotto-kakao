package lotto.view;

import lotto.domain.*;

import java.util.stream.Collectors;

public class OutputView {
    public static void printNumberOfLottoTickets(int ticketCount) {
        System.out.printf("%d개를 구매했습니다.", ticketCount);
    }

    public static void printLottoTickets(LottoTickets lottoTickets) {
        StringBuilder message = new StringBuilder();

        lottoTickets.getTickets()
                .forEach(lottoTicket -> {
                    String numbers = lottoTicket.toStream()
                            .map(LottoNumber::getNumber)
                            .map(num -> Integer.toString(num))
                            .collect(Collectors.joining(", "));

                    message.append("[")
                            .append(numbers)
                            .append("]")
                            .append(System.lineSeparator());
                });

        System.out.println(message);
    }

    public static void printStatistics(LottoStatistics statistics) {
        StringBuilder message = new StringBuilder();

        message.append("당첨 통계")
                .append(System.lineSeparator())
                .append("---------\n");

        StatisticsResult statisticsResult = statistics.getStatisticsResult();
        MatchResults matchResults = statisticsResult.getMatchResults();
        Rate earningRate = statisticsResult.getEarningRate();

        matchResults.getResultCounts()
                .entrySet()
                .stream()
                .map(entry -> {
                    MatchResult result = entry.getKey();
                    int count = entry.getValue();

                    return String.format("%d개 일치 (%d원) - %d개\n",
                            result.getMatchCount(),
                            result.getReward(),
                            count);
                })
                .forEach(message::append);

        message.append(
                String.format("총 수익률은 %d%%입니다.", earningRate.getRate()));

        System.out.println(message);
    }
}
