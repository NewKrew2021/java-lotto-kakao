package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

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
}
