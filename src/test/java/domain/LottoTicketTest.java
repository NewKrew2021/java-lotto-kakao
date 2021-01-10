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
                        Number.getNumber(1),
                        Number.getNumber(2),
                        Number.getNumber(3),
                        Number.getNumber(4),
                        Number.getNumber(5),
                        Number.getNumber(6)))
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
                        Number.getNumber(7),
                        Number.getNumber(2),
                        Number.getNumber(10),
                        Number.getNumber(4),
                        Number.getNumber(36),
                        Number.getNumber(6)))
        );
        assertThat(ticket.toString()).isEqualTo("[2, 4, 6, 7, 10, 36]");
    }

    @Test
    void matchOne() {
        assertThat(ticket.contains(Number.getNumber(1))).isEqualTo(true);
    }

    @Test
    void matchThree() {
        LottoTicket compTicket = new LottoTicket(
                Sets.newHashSet(Arrays.asList(
                        Number.getNumber(1),
                        Number.getNumber(2),
                        Number.getNumber(3),
                        Number.getNumber(7),
                        Number.getNumber(8),
                        Number.getNumber(9)))
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
                Number.getNumber(1),
                Number.getNumber(2),
                Number.getNumber(3),
                Number.getNumber(4),
                Number.getNumber(5),
                Number.getNumber(6)))
                , Number.getNumber(7));
        LottoTicket lottoTicket = new LottoTicket(
                Sets.newHashSet(Arrays.asList(
                        Number.getNumber(i1),
                        Number.getNumber(i2),
                        Number.getNumber(i3),
                        Number.getNumber(i4),
                        Number.getNumber(i5),
                        Number.getNumber(i6)))
        );
        assertThat(lottoTicket.getRank(winnerNumber)).isEqualTo(rank);
    }
}
