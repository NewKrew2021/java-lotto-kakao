package lotto.input;

import lotto.domain.LottoNumber;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.*;

class BonusNumberValidInputGuaranteerTest {
    @Test
    public void testValidInput(){
        assertThat(new BonusNumberValidInputGuaranteer().transformToObject("5")).isEqualTo(new LottoNumber(5));
    }

    @Test
    public void testInvalidInput(){
        assertThatThrownBy(()->{
            new BonusNumberValidInputGuaranteer().transformToObject("0");
        }).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()->{
            new BonusNumberValidInputGuaranteer().transformToObject("46");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}