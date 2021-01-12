package lotto.input;

import lotto.domain.LottoNumbers;
import org.assertj.core.api.AbstractThrowableAssert;
import org.junit.jupiter.api.Test;


import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.*;

class WinningLottoNumsValidInputGuaranteerTest {
    @Test
    public void testValidInput() {
        // 띄어쓰기 없이 정석 입력
        testAsserThat("1,2,3,4,5,6", new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)));
        // 띄어쓰기 있어도 가능
        testAsserThat("1, 2,3, 4,5 , 6", new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @Test
    public void testInvalidInput() {
        testAssertThrown("0,1,2,3,4,5").isInstanceOf(IllegalArgumentException.class);
        testAssertThrown("1,2,3,4,5,46").isInstanceOf(IllegalArgumentException.class);
        testAssertThrown("1,2,3,4,5,6,7").isInstanceOf(IllegalArgumentException.class);
    }

    public void testAsserThat(String userInput, LottoNumbers expectedResult) {
        assertThat(new WinningLottoNumsValidInputGuaranteer().transformToObject(userInput)).isEqualTo(expectedResult);
    }

    public AbstractThrowableAssert testAssertThrown(String userInput) {
        return assertThatThrownBy(() -> {
            new WinningLottoNumsValidInputGuaranteer().transformToObject(userInput);
        });
    }
}