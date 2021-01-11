package lotto.domain;

import org.junit.jupiter.api.Test;
import lotto.exception.NumberRangeException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoNumberTest {

    @Test
    public void create() {
        LottoNumber number1 = LottoNumber.of(7);
        LottoNumber number2 = LottoNumber.of(7);
        assertThat(number1 == number2).isTrue();
    }

    @Test
    public void validateNumberRangeUpper() {
        assertThatThrownBy(() -> {
            LottoNumber.of(46);
        }).isInstanceOf(NumberRangeException.class);
    }

    @Test
    public void validateNumberRangeLower() {
        assertThatThrownBy(() -> {
            LottoNumber.of(0);
        }).isInstanceOf(NumberRangeException.class);
    }

    @Test
    public void intToString() {
        LottoNumber lottoNumber = LottoNumber.of(7);
        assertThat(lottoNumber.getNumberToString()).isEqualTo("7");
    }
}
