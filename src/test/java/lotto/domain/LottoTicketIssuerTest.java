package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class LottoTicketIssuerTest {
    @Test
    void issueTest() {
        int ticketCount = 2;
        LottoTickets tickets = LottoTicketIssuer.issue(() -> Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::new)
                .collect(Collectors.toList()), ticketCount);

        assertThat(tickets.getTicketsNum()).isEqualTo(ticketCount);
    }
}
