package lotto.domain;

import lotto.StatisticsType;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.*;

public class WinningLottoNumbersTest {

    @Test
    void bonusNoTest() {
        assertThatThrownBy(() -> {
            new WinningLottoNos(Arrays.asList(1, 2, 3, 4, 5, 6), 3);
        }).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> {
            new WinningLottoNos(Arrays.asList(1, 2, 3, 4, 5, 6), 0);
        }).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> {
            new WinningLottoNos(Arrays.asList(1, 2, 3, 4, 5, 6), 46);
        }).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> {
            new WinningLottoNos(Arrays.asList(1, 2, 3, 3, 5, 5), 0);
        }).isInstanceOf(IllegalArgumentException.class);

        WinningLottoNos winningLottoNos = new WinningLottoNos(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
    }

    @Test
    void isWinningTest() {
        WinningLottoNos winningLottoNos = new WinningLottoNos(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        LottoNumbers lottoNumbers2 = new LottoNumbers(Arrays.asList(1, 2, 9, 10, 11, 12)); // 2
        LottoNumbers lottoNumbers3 = new LottoNumbers(Arrays.asList(1, 2, 3, 9, 10, 11)); // 3
        LottoNumbers lottoNumbers4 = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 10, 11)); // 4
        LottoNumbers lottoNumbers5 = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 8)); // 5
        LottoNumbers lottoNumbers5_1 = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 7)); // 5,1
        LottoNumbers lottoNumbers6 = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)); // 6

        assertThat(winningLottoNos.getMatchResult(lottoNumbers2))
                .isEqualTo(StatisticsType.NONE);
        assertThat(winningLottoNos.getMatchResult(lottoNumbers3))
                .isEqualTo(StatisticsType.THREE);
        assertThat(winningLottoNos.getMatchResult(lottoNumbers4))
                .isEqualTo(StatisticsType.FOUR);
        assertThat(winningLottoNos.getMatchResult(lottoNumbers5))
                .isEqualTo(StatisticsType.FIVE);
        assertThat(winningLottoNos.getMatchResult(lottoNumbers5_1))
                .isEqualTo(StatisticsType.FIVE_WITH_BONUS);
        assertThat(winningLottoNos.getMatchResult(lottoNumbers6))
                .isEqualTo(StatisticsType.SIX);
    }

}
