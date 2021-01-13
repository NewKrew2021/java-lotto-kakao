package lotto.domain;

import lotto.exception.InsufficientMoneyException;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.*;

public class MoneyTest {

    @Test
    public void When_TwoMoneyInitializedWithSameNumber_Expected_isEqualToTrue() {
        Money money = new Money(1000);
        assertThat(money).isEqualTo(new Money(1000));
    }

    @Test
    public void When_MoneyInitializedNumberUnder1000_Expected_ThrowException() {
        assertThatThrownBy(() -> {
            Money money = new Money(999);
        }).isInstanceOf(InsufficientMoneyException.class);
    }

    @Test
    public void testPossibleNumberBuy() {
        Money money = new Money(1001);
        assertThat(money.possibleNumberBuy()).isEqualTo(1);
    }

    @Test
    public void testGetProfitRate() {
        Money money = new Money(10000);
        assertThat(money.getProfitRate(5000)).isEqualTo(0.5);
    }
}
