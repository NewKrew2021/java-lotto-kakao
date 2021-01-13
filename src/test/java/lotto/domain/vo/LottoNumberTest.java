package lotto.domain.vo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void invalidNumbers(int value) {
        assertThatThrownBy(() -> LottoNumber.valueOf(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void testGetNumber() {
        assertThat(LottoNumber.valueOf(1).getNumber()).isEqualTo(1);
    }

    @Test
    void testCompare() {
        assertThat(LottoNumber.valueOf(5).compareTo(LottoNumber.valueOf(3))).isPositive();
        assertThat(LottoNumber.valueOf(5).compareTo(LottoNumber.valueOf(5))).isZero();
        assertThat(LottoNumber.valueOf(5).compareTo(LottoNumber.valueOf(7))).isNegative();
    }

    @Test
    void testHashCode() {
        assertThat(LottoNumber.valueOf(5).hashCode()).isEqualTo(LottoNumber.valueOf(5).hashCode());
        assertThat(LottoNumber.valueOf(5).hashCode()).isNotEqualTo(LottoNumber.valueOf(4).hashCode());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 45})
    void testValueOf(int value) {
        assertThat(LottoNumber.valueOf(value)).isEqualTo(LottoNumber.valueOf(value));
    }
}
