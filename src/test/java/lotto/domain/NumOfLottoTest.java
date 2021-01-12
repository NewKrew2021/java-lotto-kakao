package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatNoException;

public class NumOfLottoTest {
    @Test
    @DisplayName("NumOfLotto를 생성한다.")
    void create() {
        assertThatNoException().isThrownBy(() -> {
            new NumOfLotto(0);
        });
    }

    @Test
    @DisplayName("구매 개수가 음수면 예외 발생")
    void create_lessThanZero() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new NumOfLotto(-1);
        }).withMessageMatching("잘못된 구매 개수입니다.");
    }
}
