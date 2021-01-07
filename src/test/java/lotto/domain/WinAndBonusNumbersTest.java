package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class WinAndBonusNumbersTest {

    @Test
    public void create() {
        WinAndBonusNumbers winAndBonusNums = new WinAndBonusNumbers(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        assertThat(winAndBonusNums).isEqualTo(new WinAndBonusNumbers(Arrays.asList(1, 2, 3, 4, 5, 6), 7));
    }

    @Test
    public void validateDuplicationBetweenWinNumbersAndBonusNumber() {
        assertThatThrownBy(() -> {
            new WinAndBonusNumbers(Arrays.asList(1, 2, 3, 4, 5, 6), 6);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void calculateRankState() {
        WinAndBonusNumbers winAndBonusNums = new WinAndBonusNumbers(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        List<LottoNumber> userBuyNumbers = new ArrayList<>(Arrays.asList(
                new LottoNumber(2), new LottoNumber(3), new LottoNumber(4),
                new LottoNumber(5), new LottoNumber(6), new LottoNumber(7)
        ));
        assertThat(winAndBonusNums.getRankState(userBuyNumbers)).isEqualTo(RankState.SECOND);
    }
}
