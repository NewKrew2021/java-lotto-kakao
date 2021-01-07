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
    private Lotto testLotto;

    @BeforeEach
    public void setUpLotto() {
        lotto = new Lotto(Arrays.asList(1, 7, 8, 9, 10, 11), 12);
        testLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6), 12);
    }

    @RepeatedTest(100)
    public void generateLottoTest() {
        Lotto randomLotto = new Lotto();
        List<Integer> lottoNumbers = randomLotto.getLottoBalls();
        int bonusNumber = randomLotto.getBonusBall();
        assertThat(lottoNumbers.size()).isEqualTo(Lotto.LOTTO_COUNT);
        for (int lottoNumber : lottoNumbers) {
            assertThat(Collections.frequency(lottoNumbers, lottoNumber)).isEqualTo(1);
            assertThat(lottoNumber).isBetween(Lotto.LOTTO_MIN, Lotto.LOTTO_MAX);
        }
        assertThat(Collections.frequency(lottoNumbers, bonusNumber)).isEqualTo(0);
    }

    @Test
    public void hasNumberBallTest_sameBall() {
        int testNumber = testLotto.getOneBall(0);
        assertThat(lotto.hasBall(testNumber)).isTrue();
    }

    @Test
    public void hasNumberBallTest_differentBall() {
        int testNumber = testLotto.getOneBall(1);
        assertThat(lotto.hasBall(testNumber)).isFalse();
    }

    @Test
    public void calculateSameBallTest_success() {
        assertThat(lotto.calculateSameBall(testLotto)).isEqualTo(1);
    }

    @Test
    public void calculateSameBallTest_fail() {
        assertThat(lotto.calculateSameBall(testLotto)).isNotEqualTo(4);
    }

    @Test
    public void hasSameBonusBallTest() {
        assertThat(lotto.hasSameBonusBall(testLotto)).isTrue();
    }

}
