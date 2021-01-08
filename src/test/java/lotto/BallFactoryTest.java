package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BallFactoryTest {

    @Test
    @DisplayName("같은 번호를 갖는 볼이 같은 객체인지 확인한다.")
    void getBallTest() {
        assertThat(BallFactory.getBall("1")).isSameAs(BallFactory.getBall("1"));
    }
}
