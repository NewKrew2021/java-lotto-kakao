package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumberSetTest {

    @Test
    void createTest() {
        Lotto winningLotto = new Lotto("1, 2, 3, 4, 5, 6");
        Ball bonusBall = new Ball("7");
        WinningNumberSet winningNumberSet = new WinningNumberSet(winningLotto, bonusBall);
        assertThat(winningNumberSet).isEqualTo(new WinningNumberSet(winningLotto, bonusBall));
    }

    @Test
    void duplicateTest() {
        assertThatThrownBy(() -> {
            Lotto winningLotto = new Lotto("1, 2, 3, 4, 5, 6");
            Ball bonusBall = new Ball("1");
            WinningNumberSet winningNumberSet = new WinningNumberSet(winningLotto, bonusBall);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
