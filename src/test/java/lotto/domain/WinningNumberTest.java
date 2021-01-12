package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatNoException;

class WinningNumberTest {

    @Test
    @DisplayName("WinningNumber가 생성된다.")
    void fromNumbersText() {
        assertThatNoException().isThrownBy(() -> {
            WinningNumber.fromNumbersText("1, 2, 3, 4, 5, 6");
        });
    }
}
