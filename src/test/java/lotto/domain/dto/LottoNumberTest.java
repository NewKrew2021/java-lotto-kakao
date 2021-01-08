package lotto.domain.dto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class LottoNumberTest {
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void invalidNumbers(int value) {
        assertThatThrownBy(() -> new LottoNumber(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void testGetNumber() {
        assertThat(new LottoNumber(1).getNumber()).isEqualTo(1);
    }

    @Test
    void testCompare() {
        assertThat(new LottoNumber(5).compareTo(new LottoNumber(3))).isPositive();
        assertThat(new LottoNumber(5).compareTo(new LottoNumber(5))).isZero();
        assertThat(new LottoNumber(5).compareTo(new LottoNumber(7))).isNegative();
    }

    @Test
    void testHashCode() {
        assertThat(new LottoNumber(5).hashCode()).isEqualTo(new LottoNumber(5).hashCode());
        assertThat(new LottoNumber(5).hashCode()).isNotEqualTo(new LottoNumber(4).hashCode());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 45})
    void isEqualAndValid(int value) {
        assertThat(new LottoNumber(value)).isEqualTo(new LottoNumber(value));
    }

    @Test
    void isNotEqualTest(){
        assertThat(new LottoNumber(1)).isNotEqualTo(new LottoNumber(10));
    }
}
