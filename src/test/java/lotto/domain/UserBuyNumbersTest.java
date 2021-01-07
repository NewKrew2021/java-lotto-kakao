package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class UserBuyNumbersTest {

    @Test
    public void create() {
        UserBuyNumbers userBuyNumbers = new UserBuyNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(userBuyNumbers).isEqualTo(new UserBuyNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @Test
    public void validateSevenNums() {
        assertThatThrownBy(() -> {
            new UserBuyNumbers(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void validateFiveNums() {
        assertThatThrownBy(() -> {
            new UserBuyNumbers(Arrays.asList(1, 2, 3, 4, 5));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void validateDuplication() {
        assertThatThrownBy(() -> {
            new UserBuyNumbers(Arrays.asList(1, 1, 2, 3, 4, 5));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void checkRankSecond() {
        WinAndBonusNumbers winAndBonusNumbers = new WinAndBonusNumbers(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        UserBuyNumbers userBuyNumbers = new UserBuyNumbers(Arrays.asList(1, 2, 3, 4, 5, 7));
        assertThat(userBuyNumbers.calculateRank(winAndBonusNumbers)).isEqualTo(RankState.SECOND);
    }

    @Test
    public void checkRankFail() {
        WinAndBonusNumbers winAndBonusNumbers = new WinAndBonusNumbers(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        UserBuyNumbers userBuyNumbers = new UserBuyNumbers(Arrays.asList(40, 41, 42, 43, 44, 45));
        assertThat(userBuyNumbers.calculateRank(winAndBonusNumbers)).isEqualTo(RankState.FAIL);
    }

    @Test
    public void intToStringList() {
        UserBuyNumbers userBuyNumbers = new UserBuyNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<String> expected = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5", "6"));
        assertThat(userBuyNumbers.convertToString()).isEqualTo(expected);
    }
}
