package domain;

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
                        Number.from(1),
                        Number.from(2),
                        Number.from(3),
                        Number.from(4),
                        Number.from(5),
                        Number.from(6)))
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
                        Number.from(7),
                        Number.from(2),
                        Number.from(10),
                        Number.from(4),
                        Number.from(36),
                        Number.from(6)))
        );
        assertThat(ticket.toString()).isEqualTo("[2, 4, 6, 7, 10, 36]");
    }

    @Test
    void matchOne() {
        assertThat(ticket.contains(Number.from(1))).isEqualTo(true);
    }

    @Test
    void matchThree() {
        LottoTicket compTicket = new LottoTicket(
                Sets.newHashSet(Arrays.asList(
                        Number.from(1),
                        Number.from(2),
                        Number.from(3),
                        Number.from(7),
                        Number.from(8),
                        Number.from(9)))
        );
        assertThat(ticket.matchCount(compTicket)).isEqualTo(3);
        assertThat(ticket.matchCount(compTicket)).isNotEqualTo(4);
    }

    @ParameterizedTest
    @CsvSource({"1,6,3,5,4,2,FIRST", "3,2,1,7,5,4,SECOND", "3,40,30,2,7,5,FIFTH"})
    void matchWinnerNumberTest(int i1,
                               int i2,
                               int i3,
                               int i4,
                               int i5,
                               int i6,
                               LottoRank rank) {
        WinnerNumber winnerNumber = new WinnerNumber(Sets.newHashSet(Arrays.asList(
                Number.from(1),
                Number.from(2),
                Number.from(3),
                Number.from(4),
                Number.from(5),
                Number.from(6)))
                , Number.from(7));
        LottoTicket lottoTicket = new LottoTicket(
                Sets.newHashSet(Arrays.asList(
                        Number.from(i1),
                        Number.from(i2),
                        Number.from(i3),
                        Number.from(i4),
                        Number.from(i5),
                        Number.from(i6)))
        );
        assertThat(lottoTicket.getRank(winnerNumber)).isEqualTo(rank);
    }
}
