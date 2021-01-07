package lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BallTest {
    @Test
    void createTest() {
        Ball ball = new Ball("3");
        assertThat(ball).isEqualTo(new Ball("3"));
    }

    @Test
    void integerTest() {
        assertThatThrownBy(() -> {
            Ball ball = new Ball("a");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource({"0", "46"})
    void rangeTest(String ballString) {
        assertThatThrownBy(() -> {
            Ball ball = new Ball(ballString);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
