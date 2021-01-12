package lotto.domain;

import lotto.exception.NumberDuplicateException;
import lotto.exception.NumbersSizeException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class LottoNumbersTest {

    @Test
    public void When_LottoNumberOfTwoLottoNumbersEqual_Expect_isEqualToTrue() {
        LottoNumbers lottoNums = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lottoNums).isEqualTo(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @Test
    public void When_LottoNumbersHas7Numbers_Expect_ThrowException() {
        assertThatThrownBy(() -> {
            new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        }).isInstanceOf(NumbersSizeException.class);
    }

    @Test
    public void When_LottoNumbersHas5Numbers_Expect_ThrowException() {
        assertThatThrownBy(() -> {
            new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5));
        }).isInstanceOf(NumbersSizeException.class);
    }

    @Test
    public void When_LottoNumbersHasDuplicatedNumber_Expect_ThrowException() {
        assertThatThrownBy(() -> {
            new LottoNumbers(Arrays.asList(1, 1, 2, 3, 4, 5));
        }).isInstanceOf(NumberDuplicateException.class);
    }

    @Test
    public void When_LottoNumbersHasNumber3_Expect_isContain3ToTrue() {
        LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lottoNumbers.isContains(LottoNumber.of(3))).isTrue();
    }

    @Test
    public void When_LottoNumbersHasNotNumber7_Expect_isContain7ToFalse() {
        LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lottoNumbers.isContains(LottoNumber.of(7))).isFalse();
    }

    @Test
    public void When_TwoLottoNumbersHas4Intersection_Expect_getMatchCountWithTo4() {
        LottoNumbers lottoNumbers1 = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoNumbers lottoNumbers2 = new LottoNumbers(Arrays.asList(3, 4, 5, 6, 7, 8));
        assertThat(lottoNumbers1.getMatchCountWith(lottoNumbers2)).isEqualTo(4);
    }

    @Test
    public void testConvertToString() {
        LottoNumbers lottoNumbers1 = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lottoNumbers1.convertToString()).isEqualTo(Arrays.asList("1", "2", "3", "4", "5", "6"));
    }
}
