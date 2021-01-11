package lotto.domain;

import lotto.exception.NumberDuplicateException;
import lotto.exception.NumbersSizeException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoNumbersTest {

    @Test
    public void create() {
        LottoNumbers lottoNums = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lottoNums).isEqualTo(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)));
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
        LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(1,2,3,4,5,6));
        assertThat(lottoNumbers.isContains(LottoNumber.of(3))).isTrue();
    }

    @Test
    public void containFalse() {
        LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(1,2,3,4,5,6));
        assertThat(lottoNumbers.isContains(LottoNumber.of(7))).isFalse();
    }

    @Test
    public void matchCount() {
        LottoNumbers lottoNumbers1 = new LottoNumbers(Arrays.asList(1,2,3,4,5,6));
        LottoNumbers lottoNumbers2 = new LottoNumbers(Arrays.asList(3,4,5,6,7,8));
        assertThat(lottoNumbers1.getMatchCountWith(lottoNumbers2)).isEqualTo(4);
    }

    @Test
    public void convertToString() {
        LottoNumbers lottoNumbers1 = new LottoNumbers(Arrays.asList(1,2,3,4,5,6));
        assertThat(lottoNumbers1.convertToString()).isEqualTo(Arrays.asList("1","2","3","4","5","6"));
    }
}
