package lotto.util;

import lotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatNoException;

class LottoNumberParserTest {

    @Test
    @DisplayName("WinningNumber가 생성된다.")
    void toLottoNumbers() {
        assertThatNoException().isThrownBy(() -> {
            LottoNumberParser.toLottoNumbers("1, 2, 3, 4, 5, 6");
        });
    }

    @ParameterizedTest
    @DisplayName("숫자가 6개가 아니면 예외발생.")
    @ValueSource(strings = {"1, 2, 3, 4, 5", "1, 2, 3, 4, 5, 6, 7", "1, 1, 2, 3, 4, 5"})
    void toLottoNumbers_wrongNumOfNumbers(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            LottoNumberParser.toLottoNumbers(input);
        }).withMessageMatching("로또 번호를 중복 없이 6개 입력해주세요.");
    }

    @Test
    @DisplayName("숫자가 아닌 입력값이 있으면 예외발생.")
    void toLottoNumbers_notNumber() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            LottoNumberParser.toLottoNumbers("1, a, 2, 3, 4, 5");
        }).withMessageMatching("입력값이 숫자가 아닙니다.");
    }

    @ParameterizedTest
    @DisplayName("1~45 범위가 아닌 숫자가 있으면 예외발생.")
    @ValueSource(strings = {"0, 1, 2, 3, 4, 5", "41, 42, 43, 44, 45, 46"})
    void toLottoNumbers_outOfRange(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            LottoNumberParser.toLottoNumbers(input);
        }).withMessageMatching("로또 번호는 1~45 사이의 정수여야 합니다.");
    }

    static Stream<Arguments> provideLottoNumber() {
        return Stream.of(Arguments.of(LottoNumber.of(1), true),
                Arguments.of(LottoNumber.of(10), false));
    }
}
