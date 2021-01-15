package domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoNumberTest {
    @ParameterizedTest
    @ValueSource(ints = {46, 47, 48, 49, 50})
    void 범위_45_이상(int number) {
        assertThatExceptionOfType(InvalidLottoException.class)
                .isThrownBy(() -> new LottoNumber(number))
                .withMessageContaining("로또 범위 밖입니다.");

    }

    @ParameterizedTest
    @ValueSource(ints = {-3, -2, -1, 0})
    void 범위_0_이하(int number) {
        assertThatExceptionOfType(InvalidLottoException.class)
                .isThrownBy(() -> new LottoNumber(number))
                .withMessageContaining("로또 범위 밖입니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6,7})
    void 같은_숫자(int number) {
        LottoNumber lottoNumber = new LottoNumber(number);

        assertThat(lottoNumber.equals(new LottoNumber(number)))
                .isTrue();
    }
}

