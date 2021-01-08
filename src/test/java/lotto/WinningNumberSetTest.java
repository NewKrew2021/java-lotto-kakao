package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumberSetTest {

    @Test
    @DisplayName("WinningNumberSet 클래스에 올바른 입력이 주어졌을 때 정상적으로 생성되는지 확인한다.")
    void createTest() {
        Lotto winningLotto = new Lotto("1, 2, 3, 4, 5, 6");
        Ball bonusBall = Ball.createBall("7");
        WinningNumberSet winningNumberSet = new WinningNumberSet(winningLotto, bonusBall);
        assertThat(winningNumberSet).isEqualTo(new WinningNumberSet(winningLotto, bonusBall));
    }

    @Test
    @DisplayName("WinningNumberSet 클래스에 당첨번호와 보너스번호가 중복되는 경우 예외가 발생하는지 확인한다.")
    void duplicateTest() {
        assertThatThrownBy(() -> {
            Lotto winningLotto = new Lotto("1, 2, 3, 4, 5, 6");
            Ball bonusBall = Ball.createBall("1");
            WinningNumberSet winningNumberSet = new WinningNumberSet(winningLotto, bonusBall);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
