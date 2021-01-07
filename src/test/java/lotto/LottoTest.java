package lotto;

import java.util.*;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @Test
    void createTest() {
        Lotto lotto = new Lotto("1, 2, 3, 4, 5, 6");
        assertThat(lotto).isEqualTo(new Lotto("1, 2, 3, 4, 5, 6"));
    }

    @Test
    void lottoRangeTest() {
        assertThatThrownBy(() -> {
            Lotto lotto = new Lotto("0, 1, 2, 3, 4, 5");
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            Lotto lotto = new Lotto("1, 2, 3, 4, 5, 46");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void lottoNotIntegerTest() {
        assertThatThrownBy(() -> {
            Lotto lotto = new Lotto("1, a, 2, 3, 4, 5");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void lottoDuplicateTest() {
        assertThatThrownBy(() -> {
            Lotto lotto = new Lotto("1, 1, 2, 3, 4, 5");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void lottoCountTest() {
        assertThatThrownBy(() -> {
            Lotto lotto = new Lotto("1, 2, 3, 4, 5, 6, 7");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void lottoDuplicateCountTest() {
        assertThatThrownBy(() -> {
            Lotto lotto = new Lotto("1, 1, 2, 3, 4, 5, 6");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void containsBallTest() {
        Ball includedBall = new Ball("3");
        Ball excludedBall = new Ball("7");
        Lotto lotto = new Lotto("1, 2, 3, 4, 5, 6");
        assertThat(lotto.contains(includedBall)).isTrue();
        assertThat(lotto.contains(excludedBall)).isFalse();
    }

    @Test
    void compareWithBallsTest() {
        List<Ball> balls = Arrays.asList(new Ball("1"),
                new Ball("2"),
                new Ball("3"),
                new Ball("4"),
                new Ball("5"),
                new Ball("6"));
        Lotto lotto = new Lotto("1, 2, 3, 4, 5, 6");
        assertThat(lotto.compareWithBalls(balls)).isEqualTo(6);
    }
}
