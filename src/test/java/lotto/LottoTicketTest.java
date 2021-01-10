package lotto;

import lotto.domain.LottoRank;
import lotto.domain.LottoTicket;
import lotto.domain.Number;
import lotto.domain.WinningNumber;
import org.assertj.core.util.Sets;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class LottoTicketTest {

    private LottoTicket ticket;

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
    void toStringTest() {
        assertThat(ticket.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @Test
    void toStringOrderTest() {
        ticket = new LottoTicket(
                Sets.newHashSet(Arrays.asList(
                        new Number(7),
                        new Number(2),
                        new Number(10),
                        new Number(4),
                        new Number(36),
                        new Number(6)))
        );
        assertThat(ticket.toString()).isEqualTo("[2, 4, 6, 7, 10, 36]");
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
