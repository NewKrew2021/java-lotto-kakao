package lotto;

import lotto.domain.Number;
import lotto.domain.LottoNumber;
import lotto.exception.InvalidNumberException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class NumberTest {
    @Test
    void createNumberTest() {
        Number number = new Number(1);
        assertThat(number).isEqualTo(new Number(1));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void exceptionTest(int invalidNumber) {
        assertThatThrownBy(() -> new Number(invalidNumber))
                .isInstanceOf(InvalidNumberException.class);
    }

}
