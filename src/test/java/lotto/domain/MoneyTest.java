package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class MoneyTest {

    @Test
    public void creatTest() {
        assertThat(new Money(14000)).isEqualTo(new Money(14000));
    }

    @Test
    @DisplayName("잘못된 금액을 입력하면 예외 발생.")
    public void exceptionTest(){
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(()->{
            new Money(999);
            new Money(-1000);
        }).withMessageMatching("천원 이상의 금액을 입력해 주세요");
    }

    @Test
    @DisplayName("구매가능한 로또 개수를 반환한다.")
    public void howManyTest() {
        Money money = new Money(14000);
        assertThat(money.howMany()).isEqualTo(14);
    }
}
