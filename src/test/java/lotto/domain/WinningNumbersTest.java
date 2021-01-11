package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class WinningNumbersTest {

    @Test
    public void create() {
        WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        assertThat(winningNumbers).isEqualTo(new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6), 7));
    }

    @Test
    public void validateDuplicationBetweenWinNumbersAndBonusNumber() {
        assertThatThrownBy(() -> {
            new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6), 6);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
