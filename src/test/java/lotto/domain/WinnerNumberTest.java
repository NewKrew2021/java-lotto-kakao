package lotto.domain;

import org.assertj.core.util.Sets;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class WinnerNumberTest {
    WinnerNumber winnerNumber;

    @BeforeEach
    void setUp() {
        winnerNumber = WinnerNumber.from("1, 2, 3, 4, 5, 6", 7);
    }

    @Test
    @DisplayName("팩토리 메소드 테스트")
    void factoryMethodTest() {
        assertThat(winnerNumber).isEqualTo(new WinnerNumber(
                Sets.newTreeSet(new Number(1),
                        new Number(2),
                        new Number(3),
                        new Number(4),
                        new Number(5),
                        new Number(6)), new Number(7)));
    }

    @Test
    @DisplayName("WinnerNumber 클래스 생성 테스트")
    void createWinnerNumberTest() {
        assertThat(winnerNumber.toString()).isEqualTo("[1, 2, 3, 4, 5, 6] bonusNumber : 7");
    }

    @ParameterizedTest
    @DisplayName("LottoTicket의 등수 테스트")
    @CsvSource({"1,6,3,5,4,2,FIRST", "3,2,1,7,5,4,SECOND", "3,40,30,2,7,5,FIFTH"})
    void matchWinnerNumberTest(int i1, int i2, int i3, int i4, int i5, int i6, LottoRank rank) {
        LottoTicket lottoTicket = new LottoTicket(
                Sets.newTreeSet(
                        new Number(i1),
                        new Number(i2),
                        new Number(i3),
                        new Number(i4),
                        new Number(i5),
                        new Number(i6))
        );
        assertThat(winnerNumber.getRank(lottoTicket)).isEqualTo(rank);
    }
}
