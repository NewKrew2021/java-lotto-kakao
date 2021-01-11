package lotto.domain;

import lotto.exception.TooLowMoneyException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class MoneyTest {

    @Test
    public void creatTest() {
        assertThat(new Money(14000)).isEqualTo(new Money(14000));
    }

    @Test
    public void exceptionTest() {
        assertThatExceptionOfType(TooLowMoneyException.class).isThrownBy(() -> {
            new Money(-1000);
        }).withMessageContaining("원 이상의 금액을 입력해 주세요");
    }

    @Test
    public void howManyTest() {
        Money money = new Money(14000);
        assertThat(money.howMany(Lotto.getLottoPrice())).isEqualTo(14);
    }
}