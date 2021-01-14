package lotto.domain;

import lotto.exception.NumberDuplicateException;
import lotto.exception.NumbersSizeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class LottoNumbersTest {

    LottoNumbers lottoNumbers;

    @BeforeEach
    void setUp() {
        lottoNumbers = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @Test
    public void createEqualInstance() {
        assertThat(lottoNumbers).isEqualTo(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @Test
    public void validateSevenOfWins() {
        assertThatThrownBy(() -> {
            new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        }).isInstanceOf(NumbersSizeException.class);
    }

    @Test
    public void validateFiveOfWins() {
        assertThatThrownBy(() -> {
            new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5));
        }).isInstanceOf(NumbersSizeException.class);
    }

    @Test
    public void validateDuplication() {
        assertThatThrownBy(() -> {
            new LottoNumbers(Arrays.asList(1, 1, 2, 3, 4, 5));
        }).isInstanceOf(NumberDuplicateException.class);
    }

    @Test
    public void containTrue() {
        assertThat(lottoNumbers.isContains(LottoNumber.of(3))).isTrue();
    }

    @Test
    public void containFalse() {
        assertThat(lottoNumbers.isContains(LottoNumber.of(7))).isFalse();
    }

    @Test
    public void matchCount() {
        LottoNumbers lottoNumbers2 = new LottoNumbers(Arrays.asList(3,4,5,6,7,8));
        assertThat(lottoNumbers.getMatchCount(lottoNumbers2)).isEqualTo(4);
    }

    @Test
    public void convertToString() {
        assertThat(lottoNumbers.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }
}
