package lotto.domain;

import lotto.domain.vo.LottoNumber;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketsTest {
    @Test
    void ticketsSuccessfullyIssued() {
        List<LottoNumber> ticket = LottoNumberArray.asList(1, 2, 3, 4, 5, 6);
        List<LottoNumbers> tickets = Arrays.asList(
                new LottoNumbers(ticket),
                new LottoNumbers(ticket),
                new LottoNumbers(ticket));

        assertThat(new LottoTickets(tickets)).isEqualTo(new LottoTickets(tickets));
    }
}
