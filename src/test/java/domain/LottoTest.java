package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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

}
