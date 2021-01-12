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
            new Money("abcd101");
        }).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()->{
            new Money("999");
        }).isInstanceOf(IllegalArgumentException.class);

        Money money1 = new Money("1000");
        Money money2 = new Money("50000");
    }

    @ParameterizedTest
    @CsvSource("abcd101,999,1000")
    void checkValidationInputMoney(String includeChar, String underTicket, String upperTicket) {
        boolean invalidIncludeChar = Money.checkValidationInputMoney(includeChar);
        boolean invalidUnderTicket = Money.checkValidationInputMoney(underTicket);
        boolean validTicket = Money.checkValidationInputMoney(upperTicket);

        assertThat(invalidIncludeChar).isFalse();
        assertThat(invalidUnderTicket).isFalse();
        assertThat(validTicket).isTrue();
    }

}
