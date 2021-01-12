package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class BallTest {
    @Test
    @DisplayName("Ball 생성 테스트")
    void createTest() {
        String ballText = "3";

        Ball ball = Ball.of(ballText);

        assertThat(ball).isEqualTo(Ball.of(ballText));
        assertThat(ball == Ball.of(ballText)).isTrue();
    }

    @Test
    @DisplayName("Ball 번호에 정수가 아닌 값을 입력했을 경우 예외 발생")
    void integerTest() {
        String ballText = "a";

        Throwable throwable = catchThrowable(() -> Ball.of(ballText));

        assertThat(throwable).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource({"0", "46"})
    @DisplayName("Ball 번호가 범위를 벗어났을 경우 예외 발생")
    void rangeTest(String ballText) {
        Throwable throwable = catchThrowable(() -> Ball.of(ballText));

        assertThat(throwable).isInstanceOf(IllegalArgumentException.class);
    }
}
