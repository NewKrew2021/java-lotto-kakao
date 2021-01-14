package lotto.domain;

import lotto.exception.InsufficientMoneyException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class MoneyTest {

    @Test
    public void createEqualInstance() {
        Money money = new Money(1000);
        assertThat(money).isEqualTo(new Money(1000));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 998, 999})
    public void validateNoBuyable(int value) {
        assertThatThrownBy(() -> {
            new Money(value);
        }).isInstanceOf(InsufficientMoneyException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {1000, 1001, 1999})
    public void buyHowMany(int value) {
        Money money = new Money(value);
        assertThat(money.possibleNumberBuy()).isEqualTo(1);
    }

    @Test
    public void profitRate() {
        Money money = new Money(10000);
        assertThat(money.getProfitRate(5000)).isEqualTo(-0.5);
    }
}
