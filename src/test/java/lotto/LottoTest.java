package lotto;

import java.util.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @Test
    @DisplayName("Lotto 클래스에 올바른 입력이 주어졌을 때 정상적으로 생성되는지 확인한다.")
    void createTest() {
        Lotto lotto = new Lotto("1, 2, 3, 4, 5, 6");
        assertThat(lotto).isEqualTo(new Lotto("1, 2, 3, 4, 5, 6"));
    }

    @ParameterizedTest
    @DisplayName("Lotto 클래스에 정수여부 / 범위 / 중복 / 개수에 따라 예외가 발생하는지 확인한다.")
    @ValueSource(strings = {"0, 1, 2, 3, 4, 5",
            "1, 2, 3, 4, 5, 46",
            "1, a, 2, 3, 4, 5",
            "1, 1, 2, 3, 4, 5",
            "1, 2, 3, 4, 5, 6, 7",
            "1, 1, 2, 3, 4, 5, 6"})
    void checkLottoValidationTest(String lottoText) {
        assertThatThrownBy(() -> {
            Lotto lotto = new Lotto(lottoText);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Lotto 안에 특정 볼이 포함되었는지 확인하는 containsBall 메서드 테스트한다.")
    void containsBallTest() {
        Ball includedBall = new Ball("3");
        Ball excludedBall = new Ball("7");
        Lotto lotto = new Lotto("1, 2, 3, 4, 5, 6");
        assertThat(lotto.contains(includedBall)).isTrue();
        assertThat(lotto.contains(excludedBall)).isFalse();
    }

    @Test
    @DisplayName("List<Ball>가 주어졌을 때 일치하는 볼 개수를 구하는 compareWithBalls 메서드를 테스트한다.")
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
