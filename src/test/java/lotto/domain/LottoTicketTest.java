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
                Sets.newTreeSet(new Number(1),
                        new Number(2),
                        new Number(3),
                        new Number(4),
                        new Number(5),
                        new Number(6))
        );
    }

    @Test
    @DisplayName("로또번호 수 테스트")
    void numberCountTest() {
        assertThatThrownBy(() -> {
            new LottoTicket(
                    Sets.newTreeSet(new Number(1),
                            new Number(2),
                            new Number(3),
                            new Number(4),
                            new Number(5))
            );
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            new LottoTicket(
                    Sets.newTreeSet(new Number(1),
                            new Number(2),
                            new Number(3),
                            new Number(4),
                            new Number(5),
                            new Number(6),
                            new Number(7))
            );
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("중복 숫자 테스트")
    void duplicatedNumberTest() {
        assertThatThrownBy(() -> {
            new LottoTicket(
                    Sets.newTreeSet(new Number(1),
                            new Number(2),
                            new Number(3),
                            new Number(4),
                            new Number(5),
                            new Number(5))
            );
        }).isInstanceOf(IllegalArgumentException.class);
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
    void containsTest() {
        assertThat(ticket.contains(new Number(1))).isEqualTo(true);
    }

}
