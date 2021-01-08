package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BallTest {

    @Test
    @DisplayName("Ball 클래스에 올바른 입력이 주어졌을 때 정상적으로 생성되는지 확인한다.")
    void createTest() {
        Ball ball = new Ball("3");
        assertThat(ball).isEqualTo(new Ball("3"));
    }

    @Test
    @DisplayName("Ball 클래스에 정수가 아닌 문자열이 주어졌을 때 예외가 발생한다.")
    void integerTest() {
        assertThatThrownBy(() -> {
            Ball ball = new Ball("a");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("Ball 클래스에 범위를 벗어나는 정수가 주어졌을 때 예외가 발생한다.")
    @CsvSource({"0", "46"})
    void rangeTest(String ballString) {
        assertThatThrownBy(() -> {
            Ball ball = new Ball(ballString);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
