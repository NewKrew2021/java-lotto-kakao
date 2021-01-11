package lotto.domain;

import org.assertj.core.util.Sets;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoTicketTest {

    private LottoTicket ticket;

    @BeforeEach
    void init() {
        ticket = new LottoTicket(
                Sets.newTreeSet(Number.of(1),
                        Number.of(2),
                        Number.of(3),
                        Number.of(4),
                        Number.of(5),
                        Number.of(6))
        );
    }

    @Test
    @DisplayName("로또번호 수 테스트")
    void numberCountTest() {
        assertThatThrownBy(() -> new LottoTicket(
                Sets.newTreeSet(Number.of(1),
                        Number.of(2),
                        Number.of(3),
                        Number.of(4),
                        Number.of(5))
        )).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new LottoTicket(
                Sets.newTreeSet(Number.of(1),
                        Number.of(2),
                        Number.of(3),
                        Number.of(4),
                        Number.of(5),
                        Number.of(6),
                        Number.of(7))
        )).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("중복 숫자 테스트")
    void duplicatedNumberTest() {
        assertThatThrownBy(() -> new LottoTicket(
                Sets.newTreeSet(Number.of(1),
                        Number.of(2),
                        Number.of(3),
                        Number.of(4),
                        Number.of(5),
                        Number.of(5))
        )).isInstanceOf(IllegalArgumentException.class);
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
                Sets.newTreeSet(Number.of(7),
                        Number.of(2),
                        Number.of(10),
                        Number.of(4),
                        Number.of(36),
                        Number.of(6))
        );
        assertThat(ticket.toString()).isEqualTo("[2, 4, 6, 7, 10, 36]");
    }

    @Test
    @DisplayName("LottoTicekt 숫자 포함 테스트")
    void containsTest() {
        assertThat(ticket.contains(Number.of(1))).isEqualTo(true);
    }

}
