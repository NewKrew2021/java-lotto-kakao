package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoTest {
    private Lotto lotto;
    private WinningLotto winningLotto;

    @BeforeEach
    public void setUpLotto() {
        lotto = new Lotto(Arrays.asList(new Ball(1), new Ball(7), new Ball(8),
                new Ball(9), new Ball(10), new Ball(11)));
        winningLotto = new WinningLotto(Arrays.asList(new Ball(1), new Ball(2), new Ball(3),
                new Ball(4), new Ball(5), new Ball(6)), 12);
    }

    @RepeatedTest(100)
    public void generateLottoTest() {
        Lotto randomLotto = new Lotto();
        List<Ball> lottoNumbers = randomLotto.getLottoBalls();
        assertThat(lottoNumbers.size()).isEqualTo(Lotto.LOTTO_COUNT);
        for (Object lottoNumber : lottoNumbers) {
            assertThat(Collections.frequency(lottoNumbers, lottoNumber)).isEqualTo(1);
        }
    }

    @Test
    @DisplayName("생성자 파라미터에 볼의 갯수가 6개가 아닐 때, 중복되는 숫자가 있을 때 테스트")
    void validator(){
        assertThatThrownBy(() -> {
            new Lotto(Arrays.asList(new Ball(1), new Ball(7), new Ball(8),
                    new Ball(9), new Ball(10)));
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            new Lotto(Arrays.asList(new Ball(1), new Ball(7), new Ball(8),
                    new Ball(9), new Ball(10), new Ball(14), new Ball(15)));
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            new Lotto(Arrays.asList(new Ball(1), new Ball(7), new Ball(8),
                    new Ball(9), new Ball(10), new Ball(10)));
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
