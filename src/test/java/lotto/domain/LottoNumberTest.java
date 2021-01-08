package lotto.domain;

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
