package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningLottoTest {

    private Lotto lotto;
    private WinningLotto winningLotto;

    @BeforeEach
    public void setUpLotto() {
        lotto = new Lotto(Arrays.asList(new Ball(1), new Ball(7), new Ball(8),
                new Ball(9), new Ball(10), new Ball(11)));
        winningLotto = new WinningLotto(Arrays.asList(new Ball(1), new Ball(2), new Ball(3),
                new Ball(4), new Ball(5), new Ball(6)), 11);
    }

    @Test
    void calculateSameBall() {
        assertThat(winningLotto.calculateSameBall(lotto)).isEqualTo(1);
    }

    @Test
    void hasSameBonusBall(){
        assertThat(winningLotto.hasSameBonusBall(lotto)).isTrue();
    }

    @Test
    @DisplayName("보너스볼과 로또 숫자가 겹칠때 예외 발생 케이스")
    void constructor(){
        assertThatThrownBy(() -> {
            new WinningLotto(Arrays.asList(new Ball(1), new Ball(2), new Ball(3),
                    new Ball(4), new Ball(5), new Ball(6)), 6);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}