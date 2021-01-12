package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class MoneyTest {

    @Test
    void moneyConstructorTest() {
        assertThatThrownBy(()->{
            new Money(999);
        }).isInstanceOf(IllegalArgumentException.class);

        Money money1 = new Money(1000);
        Money money2 = new Money(50000);
    }

    @ParameterizedTest
    @CsvSource("999,1000")
    void checkValidationInputMoney(int underTicket, int upperTicket) {
        boolean invalidTicket = Money.checkValidationInputMoney(underTicket);
        boolean validTicket = Money.checkValidationInputMoney(upperTicket);

        assertThat(invalidTicket).isFalse();
        assertThat(validTicket).isTrue();
    }

}
