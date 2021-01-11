package lotto.domain;

import org.assertj.core.util.Sets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BallCountCheckerTest {

    @Test
    @DisplayName("로또 번호 갯수 제한 테스트")
    void checkBallCountTest() {
        assertThatThrownBy(() -> BallCountChecker.checkBallCount(Sets.newTreeSet(Number.of(1), Number.of(2), Number.of(3), Number.of(4), Number.of(5)))).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> BallCountChecker.checkBallCount(Sets.newTreeSet(Number.of(1), Number.of(2), Number.of(3), Number.of(4), Number.of(5), Number.of(6), Number.of(7)))).isInstanceOf(IllegalArgumentException.class);
    }
}
