package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumberSetTest {

    @Test
    void createTest() {
        String lottoString = "1, 2, 3, 4, 5, 6";
        String bonusBallString = "7";
        WinningNumberSet winningNumberSet = new WinningNumberSet(lottoString, bonusBallString);
        assertThat(winningNumberSet).isEqualTo(new WinningNumberSet(lottoString, bonusBallString));
    }

    @Test
    void duplicateTest() {
        assertThatThrownBy(() -> {
            String lottoString = "1, 2, 3, 4, 5, 6";
            String bonusBallString = "1";
            WinningNumberSet winningNumberSet = new WinningNumberSet(lottoString, bonusBallString);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
