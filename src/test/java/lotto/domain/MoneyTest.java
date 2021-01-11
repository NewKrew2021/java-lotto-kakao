package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class MoneyTest {

    @Test
    void ValidMoneyTest() {
        assertThatThrownBy(()->{
            new Money("abcd101");
        }).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()->{
            new Money("999");
        }).isInstanceOf(IllegalArgumentException.class);

        Money money1 = new Money("1000");
        Money money2 = new Money("50000");
    }

}
