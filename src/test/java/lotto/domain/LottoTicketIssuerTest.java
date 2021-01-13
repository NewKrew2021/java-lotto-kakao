package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketIssuerTest {
    @Test
    void testIssue() {
        LottoTickets tickets = LottoTicketIssuer.issuing(() -> LottoNumberArray.asList(1, 2, 3, 4, 5, 6), 2);

        assertThat(tickets).isEqualTo(new LottoTickets(Arrays.asList(
                new LottoNumbers(LottoNumberArray.asList(1, 2, 3, 4, 5, 6)),
                new LottoNumbers(LottoNumberArray.asList(1, 2, 3, 4, 5, 6))
        )));
    }
}
