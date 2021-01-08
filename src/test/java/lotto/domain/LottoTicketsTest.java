package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import lotto.domain.dto.LottoNumber;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoTicketsTest {
    @Test
    void ticketsSuccessfullyIssued() {
        List<LottoNumber> lottoNumbers = IntStream.range(1, 7)
                        .boxed()
                        .map(LottoNumber::new)
                        .collect(Collectors.toList());
        List<LottoNumbers> tickets = Arrays.asList(
                new LottoNumbers(lottoNumbers),
                new LottoNumbers(lottoNumbers),
                new LottoNumbers(lottoNumbers));

        LottoTickets lottoTickets = new LottoTickets(tickets);

        assertThat(lottoTickets).isEqualTo(new LottoTickets(tickets));
    }
}
