package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatNoException;

class WinningNumberTest {

    @Test
    @DisplayName("WinningNumber가 생성된다.")
    void fromNumbersText() {
        assertThatNoException().isThrownBy(() -> {
            WinningNumber.fromNumbersText("1, 2, 3, 4, 5, 6");
        });
    }

    @ParameterizedTest
    @DisplayName("숫자가 6개가 아니면 예외발생.")
    @ValueSource(strings = {"1, 2, 3, 4, 5", "1, 2, 3, 4, 5, 6, 7"})
    void fromNumbersText_wrongNumOfNumbers(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            WinningNumber.fromNumbersText(input);
        }).withMessageMatching("로또 번호를 6개 입력해주세요.");
    }

    @Test
    @DisplayName("숫자가 아닌 입력값이 있으면 예외발생.")
    void fromNumbersText_notNumber() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            WinningNumber.fromNumbersText("1, a, 2, 3, 4, 5");
        }).withMessageMatching("입력값이 숫자가 아닙니다.");
    }

    @ParameterizedTest
    @DisplayName("1~45 범위가 아닌 숫자가 있으면 예외발생.")
    @ValueSource(strings = {"0, 1, 2, 3, 4, 5", "41, 42, 43, 44, 45, 46"})
    void fromNumbersText_outOfRange(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            WinningNumber.fromNumbersText(input);
        }).withMessageMatching("로또 번호는 1~45 사이의 정수여야 합니다.");
    }

    @ParameterizedTest
    @DisplayName("WinningNumber가 해당 로또번호를 가지고 있는지 확인한다.")
    @MethodSource("provideLottoNumber")
    void isContain(LottoNumber lottoNumber, boolean expected) {
        WinningNumber winningNumber = WinningNumber.fromNumbersText("1, 2, 3, 4, 5, 6");
        Assertions.assertThat(winningNumber.isContain(lottoNumber)).isEqualTo(expected);
    }

    static Stream<Arguments> provideLottoNumber() {
        return Stream.of(Arguments.of(LottoNumber.of(1), true),
                Arguments.of(LottoNumber.of(10), false));
    }
}
