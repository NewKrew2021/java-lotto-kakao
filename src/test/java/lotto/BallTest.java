package lotto;

import lotto.domain.Ball;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BallTest {
    @Test
    @DisplayName("Ball 생성 테스트")
    void createTest() {
        Ball ball = Ball.of("3");
        assertThat(ball).isEqualTo(Ball.of("3"));
        assertThat(ball == Ball.of("3")).isTrue();
    }

    @Test
    @DisplayName("Ball 번호에 정수가 아닌 값을 입력했을 경우 예외 발생")
    void integerTest() {
        assertThatThrownBy(() -> Ball.of("a")).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource({"0", "46"})
    @DisplayName("Ball 번호가 범위를 벗어났을 경우 예외 발생")
    void rangeTest(String ballString) {
        assertThatThrownBy(() -> Ball.of(ballString)).isInstanceOf(IllegalArgumentException.class);
    }
}
