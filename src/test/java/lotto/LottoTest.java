package lotto;

import java.util.*;

import lotto.domain.Ball;
import lotto.domain.Lotto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {
    @Test
    void createTest() {
        Lotto lotto = new Lotto("1, 2, 3, 4, 5, 6");
        assertThat(lotto).isEqualTo(new Lotto("1, 2, 3, 4, 5, 6"));
    }

    @ParameterizedTest
    @CsvSource({"0, 1, 2, 3, 4, 5", "1, 2, 3, 4, 5, 46"})
    void lottoRangeTest(String lottoText) {
        assertThatThrownBy(() -> new Lotto(lottoText)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void lottoNotIntegerTest() {
        assertThatThrownBy(() -> new Lotto("1, a, 2, 3, 4, 5")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void lottoDuplicateTest() {
        assertThatThrownBy(() -> new Lotto("1, 1, 2, 3, 4, 5")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void lottoCountTest() {
        assertThatThrownBy(() -> new Lotto("1, 2, 3, 4, 5, 6, 7")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void lottoDuplicateCountTest() {
        assertThatThrownBy(() -> new Lotto("1, 1, 2, 3, 4, 5, 6")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void randomNumberRangeTest() {
        List<String> lottoNumbers = Lotto.autoGenerate();
        assertThat(lottoNumbers).allMatch((lottoNumber) -> (1 <= Integer.parseInt(lottoNumber) && Integer.parseInt(lottoNumber) <= 45));
    }

    @Test
    void randomNumberDuplicateTest() {
        List<String> lottoNumbers = Lotto.autoGenerate();
        assertThat(lottoNumbers).doesNotHaveDuplicates();
    }

    @Test
    void containsBallTest() {
        Lotto lotto = new Lotto("1, 2, 3, 4, 5, 6");

        Ball includedBall = new Ball("3");
        assertThat(lotto.contains(includedBall)).isTrue();

        Ball excludedBall = new Ball("7");
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
