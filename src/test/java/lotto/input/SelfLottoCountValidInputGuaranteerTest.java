package lotto.input;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.*;

class SelfLottoCountValidInputGuaranteerTest {
    @Test
    public void validInputTest(){
        assertThat(new SelfLottoCountValidInputGuaranteer().transformToObject("3")).isEqualTo(3);
    }
}