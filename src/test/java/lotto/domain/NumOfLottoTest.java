package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

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

    @Test
    @DisplayName("현재 로또 개수에서 인자로 주어진 개수만큼을 차감한 NumOfLotto 객체를 반환한다.")
    void minus() {
        NumOfLotto minuend = new NumOfLotto(3);
        NumOfLotto subtrahend = new NumOfLotto(2);
        assertThat(minuend.minus(subtrahend).getNumOfLotto()).isEqualTo(1);
    }
}
