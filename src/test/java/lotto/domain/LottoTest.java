package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {
    @Test
    @DisplayName("Lotto 생성 테스트")
    void createTest() {
        Lotto lotto = new Lotto("1, 2, 3, 4, 5, 6");
        assertThat(lotto).isEqualTo(new Lotto("1, 2, 3, 4, 5, 6"));
    }

    @Test
    @DisplayName("Lotto 번호가 중복되었을 경우 예외 발생")
    void checkDuplicateTest() {
        assertThatThrownBy(() -> {
            new Lotto().checkDuplicate(
                    Arrays.asList(Ball.of("1"),
                            Ball.of("2"),
                            Ball.of("3"),
                            Ball.of("4"),
                            Ball.of("5"),
                            Ball.of("5"))
            );
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Lotto 번가 6개가 아닌 경우 예외 발생")
    void checkCountTest() {
        assertThatThrownBy(() -> {
            new Lotto().checkCount(
                    Arrays.asList(Ball.of("1"),
                            Ball.of("2"),
                            Ball.of("3"),
                            Ball.of("4"),
                            Ball.of("5"))
            );
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource({"0, 1, 2, 3, 4, 5", "1, 2, 3, 4, 5, 46"})
    @DisplayName("Lotto 번호가 범위를 벗어났을 경우 예외 발생")
    void lottoRangeTest(String lottoText) {
        assertThatThrownBy(() -> new Lotto(lottoText)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Lotto 번호에 정수가 아닌 값을 입력했을 경우 예외 발생")
    void lottoNotIntegerTest() {
        assertThatThrownBy(() -> new Lotto("1, a, 2, 3, 4, 5")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Lotto 번호가 중복되었을 경우 예외 발생")
    void lottoDuplicateTest() {
        assertThatThrownBy(() -> new Lotto("1, 1, 2, 3, 4, 5")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Lotto 번호가 6개가 아닌 경우 예외 발생")
    void lottoCountTest() {
        assertThatThrownBy(() -> new Lotto("1, 2, 3, 4, 5, 6, 7")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Lotto 번호가 중복되고 번호가 6개가 아닌 경우 예외 발생")
    void lottoDuplicateCountTest() {
        assertThatThrownBy(() -> new Lotto("1, 1, 2, 3, 4, 5, 6")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Lotto 번호를 자동으로 생성했을 때 범위가 올바른지 테스트")
    void randomNumberRangeTest() {
        List<Integer> lottoNumbers = LottoNumberPool.autoGenerate();
        assertThat(lottoNumbers).allMatch((lottoNumber) -> (1 <= lottoNumber && lottoNumber <= 45));
    }

    @Test
    @DisplayName("Lotto 번호를 자동으로 생성했을 때 번호가 중복되지 않는지 테스트")
    void randomNumberDuplicateTest() {
        List<Integer> lottoNumbers = LottoNumberPool.autoGenerate();
        assertThat(lottoNumbers).doesNotHaveDuplicates();
    }

    @Test
    @DisplayName("Lotto 번호와 Ball 번호 사이의 중복여부 판단 테스트")
    void containsBallTest() {
        Lotto lotto = new Lotto("1, 2, 3, 4, 5, 6");

        Ball includedBall = Ball.of("3");
        assertThat(lotto.contains(includedBall)).isTrue();

        Ball excludedBall = Ball.of("7");
        assertThat(lotto.contains(excludedBall)).isFalse();
    }

    @Test
    @DisplayName("Lotto 번호와 여러 Ball 번호 사이의 일치개수 테스트")
    void compareWithBallsTest() {
        List<Ball> balls = Arrays.asList(Ball.of("1"),
                Ball.of("2"),
                Ball.of("3"),
                Ball.of("4"),
                Ball.of("5"),
                Ball.of("6"));
        Lotto lotto = new Lotto("1, 2, 3, 4, 5, 6");
        assertThat(lotto.compareWithBalls(balls)).isEqualTo(6);
    }
}
