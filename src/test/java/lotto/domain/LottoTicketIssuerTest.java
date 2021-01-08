package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class LottoTicketIssuerTest {
    @ParameterizedTest
    @ValueSource(ints = {0, 1000, 1999, 2000, 2001})
    void issueTest(int insertPrice) {
        LottoTickets tickets = LottoTicketIssuer.issue(() -> Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::new)
                .collect(Collectors.toList()), insertPrice);
        assertThat(tickets.getTicketsNum()).isEqualTo(insertPrice / LottoTicketIssuer.TICKET_PRICE);
    }
}
