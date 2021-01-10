package lotto.view;

import lotto.domain.*;
import lotto.domain.dto.LottoNumber;

import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OutputView {
    public void printNumberOfLottoTickets(int ticketCount, int change) {
        System.out.printf("%d개를 구매했습니다.\n", ticketCount);

        if (hasChange(change)) {
            System.out.printf("잔돈 %d원은 반환되었습니다.\n", change);
        }
    }

    public void printLottoTickets(LottoTickets lottoTickets) {
        StringBuilder message = new StringBuilder();
        Consumer<LottoNumbers> lottoTicketConsumer = lottoTicket ->
                lottoTicket.delegate(lottoNumbers ->
                        message.append(String.format("[%s]\n", lottoNumbers.stream()
                                .map(LottoNumber::getNumber)
                                .map(num -> Integer.toString(num))
                                .collect(Collectors.joining(", ")))));

        lottoTickets.delegate(tickets -> tickets.forEach(lottoTicketConsumer));

        System.out.println(message);
    }

    public void printStatistics(LottoStatistics statistics) {
        StringBuilder message = new StringBuilder();
        StatisticsResult statisticsResult = statistics.getStatisticsResult();

        message.append("당첨 통계\n")
                .append("---------\n");

        Stream.of(MatchResult.values())
                .map(result -> {
                    int count = statisticsResult.getResultCountOfSomeMatch(result);
                    return String.format("%s (%d원) - %d개%n", result.getInfo(), result.getReward(), count);
                })
                .forEach(message::append);

        message.append(String.format("총 수익률은 %d%%입니다.", statisticsResult.getEarningRate()));

        System.out.println(message);
    }

    private boolean hasChange(int change) {
        return change > 0;
    }
}
