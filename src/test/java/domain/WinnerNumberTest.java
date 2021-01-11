package domain;

import org.assertj.core.util.Sets;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class WinnerNumberTest {

    @Test
    void createWinnerNumberTest() {
        WinnerNumber winnerNumber = new WinnerNumber(Sets.newHashSet(Arrays.asList(
                Number.from(1),
                Number.from(2),
                Number.from(3),
                Number.from(4),
                Number.from(5),
                Number.from(6)))
        , Number.from(7));
        assertThat(winnerNumber.toString()).isEqualTo("[1, 2, 3, 4, 5, 6] bonusNumber : 7");
    }
}
