package lotto.domain;

import lotto.utils.Result;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {
    @Test
    void 로또번호일치() {
        WinningLotto winningLotto = new WinningLotto(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new LottoNumber(10));

        assertThat(winningLotto.compare(new Lotto(Arrays.asList(5, 6, 7, 8, 9, 10)))).isEqualTo(Result.UNDERTHREE);
        assertThat(winningLotto.compare(new Lotto(Arrays.asList(4, 5, 6, 7, 8, 9)))).isEqualTo(Result.THREE);
        assertThat(winningLotto.compare(new Lotto(Arrays.asList(3, 4, 5, 6, 7, 8)))).isEqualTo(Result.FOUR);
        assertThat(winningLotto.compare(new Lotto(Arrays.asList(2, 3, 4, 5, 6, 9)))).isEqualTo(Result.FIVE);
        assertThat(winningLotto.compare(new Lotto(Arrays.asList(2, 3, 4, 5, 6, 10)))).isEqualTo(Result.BONUSFIVE);
        assertThat(winningLotto.compare(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)))).isEqualTo(Result.SIX);
    }

    @Test
    void create() {
        WinningLotto winningLotto = new WinningLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        assertThat(winningLotto)
                .isEqualTo(new WinningLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))));
    }
}
