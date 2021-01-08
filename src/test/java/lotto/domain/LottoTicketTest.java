package lotto.domain;

import lotto.domain.LottoRank;
import lotto.domain.LottoTicket;
import lotto.domain.Number;
import lotto.domain.WinnerNumber;
import org.assertj.core.util.Sets;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class LottoTicketTest {

    private LottoTicket ticket;

    @BeforeEach
    void init() {
        ticket = new LottoTicket(
                Sets.newTreeSet(new Number(1),
                        new Number(2),
                        new Number(3),
                        new Number(4),
                        new Number(5),
                        new Number(6))
        );
    }

    @Test
    @DisplayName("toString() 테스트")
    void toStringTest() {
        assertThat(ticket.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @Test
    @DisplayName("LottoTicket 출력 시 번호 정렬 테스트")
    void toStringOrderTest() {
        ticket = new LottoTicket(
                Sets.newTreeSet(new Number(7),
                        new Number(2),
                        new Number(10),
                        new Number(4),
                        new Number(36),
                        new Number(6))
        );
        assertThat(ticket.toString()).isEqualTo("[2, 4, 6, 7, 10, 36]");
    }

    @Test
    @DisplayName("LottoTicekt 숫자 포함 테스트")
    void matchOne() {
        assertThat(ticket.contains(new Number(1))).isEqualTo(true);
    }

    @Test
    @DisplayName("LottoTicekt간의 일치하는 숫자 갯수 테스트")
    void matchThree() {
        LottoTicket compTicket = new LottoTicket(
                Sets.newTreeSet(new Number(1),
                        new Number(2),
                        new Number(3),
                        new Number(7),
                        new Number(8),
                        new Number(9))
        );
        assertThat(ticket.matchCount(compTicket)).isEqualTo(3);
        assertThat(ticket.matchCount(compTicket)).isNotEqualTo(4);
    }

    @ParameterizedTest
    @DisplayName("LottoTicket의 등수 테스트")
    @CsvSource({"1,6,3,5,4,2,FIRST", "3,2,1,7,5,4,SECOND", "3,40,30,2,7,5,FIFTH"})
    void matchWinnerNumberTest(int i1, int i2, int i3, int i4, int i5, int i6, LottoRank rank) {
        WinnerNumber winnerNumber = new WinnerNumber(Sets.newTreeSet(
                new Number(1),
                new Number(2),
                new Number(3),
                new Number(4),
                new Number(5),
                new Number(6))
                , new Number(7)
        );
        LottoTicket lottoTicket = new LottoTicket(
                Sets.newTreeSet(
                        new Number(i1),
                        new Number(i2),
                        new Number(i3),
                        new Number(i4),
                        new Number(i5),
                        new Number(i6))
        );
        assertThat(lottoTicket.getRank(winnerNumber)).isEqualTo(rank);
    }

}
