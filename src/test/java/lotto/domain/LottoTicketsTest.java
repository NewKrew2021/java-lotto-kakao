package lotto.domain;

import lotto.domain.vo.LottoNumber;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketsTest {
    @Test
    void testJoin() {
        List<LottoNumbers> tickets1 = Arrays.asList(
                new LottoNumbers(LottoNumberArray.asList(1, 2, 3, 4, 5, 6)),
                new LottoNumbers(LottoNumberArray.asList(1, 2, 3, 4, 5, 7)),
                new LottoNumbers(LottoNumberArray.asList(1, 2, 3, 4, 5, 8)));
        List<LottoNumbers> tickets2 = Arrays.asList(
                new LottoNumbers(LottoNumberArray.asList(1, 2, 3, 4, 5, 9)),
                new LottoNumbers(LottoNumberArray.asList(1, 2, 3, 4, 5, 10)),
                new LottoNumbers(LottoNumberArray.asList(1, 2, 3, 4, 5, 11)));
        LottoTickets lottoTickets = new LottoTickets(tickets1);
        LottoTickets appendTickets = new LottoTickets(tickets2);

        assertThat(lottoTickets.join(appendTickets))
                .isEqualTo(new LottoTickets(Stream.of(tickets1, tickets2)
                        .flatMap(List::stream)
                        .collect(Collectors.toList())));
    }

    @Test
    void ticketsSuccessfullyIssued() {
        List<LottoNumber> ticket = LottoNumberArray.asList(1, 2, 3, 4, 5, 6);
        List<LottoNumbers> tickets = Arrays.asList(
                new LottoNumbers(ticket),
                new LottoNumbers(ticket),
                new LottoNumbers(ticket));

        assertThat(new LottoTickets(tickets)).isEqualTo(new LottoTickets(tickets));
    }

    @Test
    void testMatchWinning() {
        List<LottoNumbers> tickets = Arrays.asList(
                new LottoNumbers(LottoNumberArray.asList(1, 2, 3, 4, 5, 6)),
                new LottoNumbers(LottoNumberArray.asList(1, 2, 3, 4, 5, 7)),
                new LottoNumbers(LottoNumberArray.asList(1, 2, 3, 4, 7, 8)),
                new LottoNumbers(LottoNumberArray.asList(1, 2, 7, 8, 9, 10)));
        WinningNumbers winningNumbers = new WinningNumbers(
                new LottoNumbers(LottoNumberArray.asList(1, 2, 3, 4, 5, 6)), LottoNumber.valueOf(7));

        assertThat(new LottoTickets(tickets).matchWinning(winningNumbers)).isEqualTo(new MatchResults(
                Arrays.asList(MatchResult.FIRST, MatchResult.SECOND, MatchResult.FOURTH, MatchResult.LOSE)));
    }
}
