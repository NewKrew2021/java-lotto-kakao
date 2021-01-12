package lotto.input;

import lotto.domain.LottoMoney;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.*;

class BuyingMoneyValidInputGuaranteerTest {
    @Test
    public void testValidInput(){
        assertThat(new BuyingMoneyValidInputGuaranteer().transformToObject("2000")).isEqualTo(new LottoMoney(2000));
    }

    @Test
    public void testInvalidInput(){
        assertThatThrownBy(() -> {
            new BuyingMoneyValidInputGuaranteer().transformToObject("500");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}