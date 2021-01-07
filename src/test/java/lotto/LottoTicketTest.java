package lotto;

import org.assertj.core.util.Sets;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class LottoTicketTest {

    private LottoTicket ticket;
    private Number n;

    @BeforeEach
    void init() {
        ticket = new LottoTicket(
                Sets.newHashSet(Arrays.asList(
                        new Number(1),
                        new Number(2),
                        new Number(3),
                        new Number(4),
                        new Number(5),
                        new Number(6)))
        );
    }

    @Test
    void matchOne() {
        assertThat(ticket.contains(new Number(1))).isEqualTo(true);
    }

    @Test
    void matchThree() {
        LottoTicket compTicket = new LottoTicket(
                Sets.newHashSet(Arrays.asList(
                        new Number(1),
                        new Number(2),
                        new Number(3),
                        new Number(7),
                        new Number(8),
                        new Number(9)))
        );
        assertThat(ticket.matchCount(compTicket)).isEqualTo(3);
        assertThat(ticket.matchCount(compTicket)).isNotEqualTo(4);
    }
}
