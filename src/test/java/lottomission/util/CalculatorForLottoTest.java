package lottomission.util;

import lottomission.domain.exception.InvalidMoneyException;
import lottomission.domain.exception.InvalidSumOfEarningMoneyException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorForLottoTest {

    @Test
    public void 수익률_테스트(){
        CalculatorForLotto cal = new CalculatorForLotto();
        assertThat((int)cal.rateOfProfit(1,2)).isEqualTo(2);
    }

    @Test
    public void 수익률_사용자돈_에러처리_테스트(){
        CalculatorForLotto cal = new CalculatorForLotto();
        assertThatThrownBy(()->
            cal.rateOfProfit(0,1)
        ).isInstanceOf(InvalidMoneyException.class);
    }

    @Test
    public void 수익률_수입금액_에러처리_테스트(){
        CalculatorForLotto cal = new CalculatorForLotto();
        assertThatThrownBy(()->
                cal.rateOfProfit(1,-1)
        ).isInstanceOf(InvalidSumOfEarningMoneyException.class);
    }

}
