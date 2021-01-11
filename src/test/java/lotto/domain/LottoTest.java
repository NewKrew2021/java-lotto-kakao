package lotto.domain;

import lotto.exception.HasDuplicateNumberException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {
    private WinningLotto winningLotto;

    @BeforeEach
    void setUp() {
        winningLotto = new WinningLotto(() -> Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @Test
    void matchTest1() {
        assertThat(winningLotto.getRankOfLotto(new Lotto(() -> Arrays.asList(1, 2, 3, 4, 5, 6)), LottoNumber.of(7))).isEqualTo(Rank.FIRST);
    }

    @Test
    void matchTest2() {
        assertThat(winningLotto.getRankOfLotto(new Lotto(() -> Arrays.asList(1, 2, 3, 4, 6, 7)), LottoNumber.of(6))).isEqualTo(Rank.SECOND);
    }

    @Test
    void matchTest3() {
        assertThat(winningLotto.getRankOfLotto(new Lotto(() -> Arrays.asList(1, 2, 3, 4, 5, 7)), LottoNumber.of(8))).isEqualTo(Rank.THIRD);
    }

    @Test
    void matchTest4() {
        assertThat(winningLotto.getRankOfLotto(new Lotto(() -> Arrays.asList(1, 2, 3, 4, 7, 8)), LottoNumber.of(9))).isEqualTo(Rank.FOURTH);
    }

    @Test
    void matchTest5() {
        assertThat(winningLotto.getRankOfLotto(new Lotto(() -> Arrays.asList(1, 2, 3, 7, 8, 9)), LottoNumber.of(10))).isEqualTo(Rank.FIFTH);
    }

    @Test
    void lottoSizeExceptionTest() {
        assertThatExceptionOfType(HasDuplicateNumberException.class).isThrownBy(() -> {
            new Lotto(Arrays.asList(1, 2, 3, 4, 5, 1));
        }).withMessageMatching("로또 번호를 잘못 입력하셨습니다.");
    }

}