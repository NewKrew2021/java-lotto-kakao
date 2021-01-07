package domain;

import org.assertj.core.util.Sets;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class WinnerNumberTest {

    @Test
    void createWinnerNumberTest() {
        WinnerNumber winnerNumber = new WinnerNumber(Sets.newHashSet(Arrays.asList(
                new Number(1),
                new Number(2),
                new Number(3),
                new Number(4),
                new Number(5),
                new Number(6)))
        , new Number(7));
        assertThat(winnerNumber.toString()).isEqualTo("[1, 2, 3, 4, 5, 6] bonusNumber : 7");
    }
}
