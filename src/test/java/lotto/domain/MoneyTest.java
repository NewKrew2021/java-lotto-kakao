package lotto.domain;

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
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void buyHowMany() {
        Money money = new Money(1001);
        assertThat(money.possibleNumberBuy()).isEqualTo(1);
    }
}
