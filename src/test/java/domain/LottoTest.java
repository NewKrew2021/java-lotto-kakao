package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoTest {
    private Lotto lotto;
    private WinningLotto winningLotto;

    @BeforeEach
    public void setUpLotto() {
        lotto = new Lotto(Arrays.asList(1, 7, 8, 9, 10, 11));
        winningLotto = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 12);
    }

    @RepeatedTest(100)
    public void generateLottoTest() {
        Lotto randomLotto = new Lotto();
        List<Integer> lottoNumbers = randomLotto.getLottoBalls();
        assertThat(lottoNumbers.size()).isEqualTo(Lotto.LOTTO_COUNT);
        for (int lottoNumber : lottoNumbers) {
            assertThat(Collections.frequency(lottoNumbers, lottoNumber)).isEqualTo(1);
        }
    }

}
