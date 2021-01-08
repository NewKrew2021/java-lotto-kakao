package lotto;

import lotto.domain.Number;
import lotto.domain.WinningNumber;
import org.assertj.core.util.Sets;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class WinningNumberTest {

    @Test
    void createWinnerNumberTest() {
        WinningNumber winningNumber = new WinningNumber(Sets.newHashSet(Arrays.asList(
                new Number(1),
                new Number(2),
                new Number(3),
                new Number(4),
                new Number(5),
                new Number(6)))
        , new Number(7));
        assertThat(winningNumber.toString()).isEqualTo("[1, 2, 3, 4, 5, 6] bonusNumber : 7");
    }
}
