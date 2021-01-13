package lotto.domain;

import lotto.exception.NumberRangeException;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoNumberTest {

    @Test
    public void When_TwoLottoNumberInitializedWithSameNumber_Expected_TwoInstanceIsEqual() {
        LottoNumber number1 = LottoNumber.of(7);
        LottoNumber number2 = LottoNumber.of(7);
        assertThat(number1 == number2).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {46, 47})
    public void When_LottoNumberInitializedWithNumberOver45_Expected_ThrowException(int number) {
        assertThatThrownBy(() -> {
            LottoNumber.of(number);
        }).isInstanceOf(NumberRangeException.class);
    }

    @Test
    public void When_LottoNumberInitializedWithNumberUnder1_Expected_ThrowException() {
        assertThatThrownBy(() -> {
            LottoNumber.of(0);
        }).isInstanceOf(NumberRangeException.class);
    }

    @Test
    public void testIntToString() {
        LottoNumber lottoNumber = LottoNumber.of(7);
        assertThat(lottoNumber.getNumberToString()).isEqualTo("7");
    }
}
