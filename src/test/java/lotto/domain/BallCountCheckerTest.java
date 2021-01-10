package lotto.domain;

import org.assertj.core.util.Sets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BallCountCheckerTest {

    @Test
    @DisplayName("")
    void checkBallCountTest() {
        assertThatThrownBy(() -> BallCountChecker.checkBallCount(Sets.newTreeSet(new Number(1), new Number(2), new Number(3), new Number(4), new Number(5)))).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> BallCountChecker.checkBallCount(Sets.newTreeSet(new Number(1), new Number(2), new Number(3), new Number(4), new Number(5), new Number(6), new Number(7)))).isInstanceOf(IllegalArgumentException.class);
    }
}
