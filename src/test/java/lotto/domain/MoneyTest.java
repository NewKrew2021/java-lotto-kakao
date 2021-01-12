package lotto.domain;

import lotto.exception.TooLowMoneyException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class MoneyTest {

    @Test
    @DisplayName("자금의 정상 생성 테스트")
    public void creatTest() {
        assertThat(new Money(14000)).isEqualTo(new Money(14000));
    }

    @Test
    @DisplayName("최소 금액 이하의 금액 입력 예외 테스트")
    public void exceptionTest() {
        assertThatExceptionOfType(TooLowMoneyException.class).isThrownBy(() -> {
            new Money(-1000);
        }).withMessageContaining("원 이상의 금액을 입력해 주세요");
    }

    @Test
    @DisplayName("금액에 따른 로또 구매 가능 갯수의 정확도")
    public void howManyTest() {
        Money money = new Money(14000);
        assertThat(money.howMany(Lotto.LOTTO_PRICE)).isEqualTo(14);
    }

    @Test
    @DisplayName("천원일때도 정상 구매 되는지 테스트")
    public void minimumBuyTest() {
        Money money = new Money(1000);
        assertThat(money.howMany(Lotto.LOTTO_PRICE)).isEqualTo(1);
    }
}