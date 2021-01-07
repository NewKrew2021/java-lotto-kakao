package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.LottoGameNumber.LOTTO_MONEY_EXCEPTION_MESSAGE;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoGameNumberTest {
    @DisplayName("금액이 들어오면, 금액의 단위에 맞는 티켓의 갯수를 반환한다.")
    @Test
    void create(){
        //given
        int money = 14000;

        //when
        LottoGameNumber lottogame = new LottoGameNumber(money);

        //then
        assertThat(lottogame.getTicketNumber()).isEqualTo(14);
    }

    @DisplayName("1000원 단위가 아닌 금액이 들어오면, 예외가 발생한다.")
    @Test
    void validateMoney1(){
        //given
        int money = 14001;

        //then
        assertThatIllegalArgumentException()
                // when
                .isThrownBy(() -> new LottoGameNumber(money))
                .withMessage(LOTTO_MONEY_EXCEPTION_MESSAGE);
    }

    @DisplayName("양의 정수가 아닌 단위의 금액이 들어오면, 예외가 발생한다.")
    @Test
    void validateMoney2(){
        //given
        int money = 0;

        //then
        assertThatIllegalArgumentException()
                // when
                .isThrownBy(() -> new LottoGameNumber(money))
                .withMessage(LOTTO_MONEY_EXCEPTION_MESSAGE);
    }
}
