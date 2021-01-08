package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import lotto.domain.dto.LottoNumber;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoTicketsTest {
    @Test
    void ticketsSuccessfullyIssued() {
        List<LottoNumber> ticket = Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        List<LottoNumbers> tickets = Arrays.asList(
                new LottoNumbers(ticket),
                new LottoNumbers(ticket),
                new LottoNumbers(ticket));

        LottoTickets lottoTickets = new LottoTickets(tickets);

        assertThat(lottoTickets).isEqualTo(new LottoTickets(tickets));
    }

    @Test
    void testDelegate() {
        List<LottoNumber> ticket = Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        LottoTickets lottoTickets = new LottoTickets(Arrays.asList(
                new LottoNumbers(ticket),
                new LottoNumbers(ticket),
                new LottoNumbers(ticket)));

        lottoTickets.delegate(tickets -> assertThat(tickets).contains(new LottoNumbers(ticket)));
    }
}
