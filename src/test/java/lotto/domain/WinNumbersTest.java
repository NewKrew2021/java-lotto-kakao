package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class WinNumbersTest {

    @Test
    public void create() {
        WinNumbers winNums = new WinNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(winNums).isEqualTo(new WinNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @Test
    public void validateSevenOfWins() {
        assertThatThrownBy(() -> {
            new WinNumbers(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void validateFiveOfWins() {
        assertThatThrownBy(() -> {
            new WinNumbers(Arrays.asList(1, 2, 3, 4, 5));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void validateDuplication() {
        assertThatThrownBy(() -> {
            new WinNumbers(Arrays.asList(1, 1, 2, 3, 4, 5));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void contain() {
        WinNumbers winNums = new WinNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoNumber num = new LottoNumber(5);
        assertThat(winNums.contains(num)).isTrue();
    }

    @Test
    public void notContain() {
        WinNumbers winNums = new WinNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoNumber num = new LottoNumber(10);
        assertThat(winNums.contains(num)).isFalse();
    }
}
