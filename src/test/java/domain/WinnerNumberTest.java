package domain;

import org.assertj.core.util.Sets;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class WinnerNumberTest {

    @Test
    void createWinnerNumberTest() {
        WinnerNumber winnerNumber = new WinnerNumber(Sets.newHashSet(Arrays.asList(
                Number.getNumber(1),
                Number.getNumber(2),
                Number.getNumber(3),
                Number.getNumber(4),
                Number.getNumber(5),
                Number.getNumber(6)))
        , Number.getNumber(7));
        assertThat(winnerNumber.toString()).isEqualTo("[1, 2, 3, 4, 5, 6] bonusNumber : 7");
    }
}
