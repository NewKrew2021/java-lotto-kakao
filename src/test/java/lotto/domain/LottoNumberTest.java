package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void testInvalidRange(int value) {
        assertThatThrownBy(() -> new LottoNumber(value)).isInstanceOf(IllegalArgumentException.class);
    }

}
