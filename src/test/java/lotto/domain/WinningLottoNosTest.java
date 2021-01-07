package lotto.domain;

import lotto.domain.LottoNos;
import lotto.domain.WinningLottoNos;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.*;

public class WinningLottoNosTest {

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
        LottoNos lottoNos2 = new LottoNos(Arrays.asList(1, 2, 9, 10, 11, 12)); // 2
        LottoNos lottoNos3 = new LottoNos(Arrays.asList(1, 2, 3, 9, 10, 11)); // 3
        LottoNos lottoNos4 = new LottoNos(Arrays.asList(1, 2, 3, 4, 10, 11)); // 4
        LottoNos lottoNos5 = new LottoNos(Arrays.asList(1, 2, 3, 4, 5, 8)); // 5
        LottoNos lottoNos5_1 = new LottoNos(Arrays.asList(1, 2, 3, 4, 5, 7)); // 5,1
        LottoNos lottoNos6 = new LottoNos(Arrays.asList(1, 2, 3, 4, 5, 6)); // 6

        assertThat(winningLottoNos.isWinning(lottoNos2))
                .isEqualTo(Arrays.asList(2, 0));
        assertThat(winningLottoNos.isWinning(lottoNos3))
                .isEqualTo(Arrays.asList(3, 0));
        assertThat(winningLottoNos.isWinning(lottoNos4))
                .isEqualTo(Arrays.asList(4, 0));
        assertThat(winningLottoNos.isWinning(lottoNos5))
                .isEqualTo(Arrays.asList(5, 0));
        assertThat(winningLottoNos.isWinning(lottoNos5_1))
                .isEqualTo(Arrays.asList(5, 1));
        assertThat(winningLottoNos.isWinning(lottoNos6))
                .isEqualTo(Arrays.asList(6, 0));

    }

}
