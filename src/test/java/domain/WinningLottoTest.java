package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class WinningLottoTest {

    private Lotto lotto;
    private WinningLotto winningLotto;

    @BeforeEach
    public void setUpLotto() {
        lotto = new Lotto(Arrays.asList(1, 7, 8, 9, 10, 11));
        winningLotto = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 11);
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
            new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 6);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}