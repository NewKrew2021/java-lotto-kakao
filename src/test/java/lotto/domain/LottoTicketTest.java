package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.*;

public class LottoTicketTest {

    private LottoTicket ticket;

    @BeforeEach
    void init() {
        ticket = LottoTicket.from("1, 2, 3, 4, 5 , 6");
    }

    @Test
    @DisplayName("로또번호 수 테스트")
    void numberCountTest() {
        assertThatThrownBy(() -> LottoTicket.from("1, 2, 3, 4, 5"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> LottoTicket.from("1, 2, 3, 4, 5, 6, 7"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("LottoTicket 팩토리 메소드 테스트")
    void fromTest() {
        assertThat(LottoTicket.from(() -> {
            return new TreeSet<>(Arrays.asList(Number.of(1), Number.of(2), Number.of(3), Number.of(4), Number.of(5), Number.of(6)));
        })).isEqualTo(LottoTicket.from("1, 2, 3, 4, 5, 6"));
    }

    @Test
    @DisplayName("중복 숫자 테스트")
    void duplicatedNumberTest() {
        assertThatThrownBy(() -> LottoTicket.from("1, 2, 3, 4, 5, 5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("toString() 테스트")
    void toStringTest() {
        assertThat(ticket.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @Test
    @DisplayName("LottoTicket 출력 시 번호 정렬 테스트")
    void toStringOrderTest() {
        ticket = LottoTicket.from("7, 2, 10, 4, 36, 6");
        assertThat(ticket.toString()).isEqualTo("[2, 4, 6, 7, 10, 36]");
    }

    @Test
    @DisplayName("LottoTicket 숫자 포함 테스트")
    void containsTest() {
        assertThat(ticket.contains(Number.of(1))).isEqualTo(true);
    }

    @ParameterizedTest
    @CsvSource({"'1, 2, 3, 4, 5, 6', 6", "'2, 3, 4, 5, 6, 7', 5", "'6, 5, 4, 9, 8, 7', 3"})
    @DisplayName("LottoTicket 숫자 비교 테스트")
    void mathCountTest(String rawNumbers, int count) {
        assertThat(ticket.matchCount(LottoTicket.from(rawNumbers))).isEqualTo(count);
    }

}
