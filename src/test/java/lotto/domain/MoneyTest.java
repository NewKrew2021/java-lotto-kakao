package lotto.domain;

import lotto.exception.InsufficientMoneyException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class MoneyTest {

    @Test
    public void create() {
        Money money = new Money(1000);
        assertThat(money).isEqualTo(new Money(1000));
    }

    @Test
    public void validateNoBuyable() {
        assertThatThrownBy(() -> {
            Money money = new Money(999);
        }).isInstanceOf(InsufficientMoneyException.class);
    }

    @Test
    public void buyHowMany() {
        Money money = new Money(1001);
        assertThat(money.possibleNumberBuy()).isEqualTo(1);
    }

    @Test
    public void profitRate() {
        Money money = new Money(10000);
        assertThat(money.getProfitRate(5000)).isEqualTo(0.5);
    }
}
