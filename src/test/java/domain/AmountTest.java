package domain;

import domain.exceptions.InvalidAmountException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class AmountTest {

    @Test
    public void create() {
        Amount amount = new Amount(1000);
        assertThat(amount).isEqualTo(new Amount(1000));
    }

    @Test
    public void isInvalidAmount() {
        assertThatExceptionOfType(InvalidAmountException.class)
                .isThrownBy(() -> new Amount(999));
    }

    @ParameterizedTest
    @CsvSource({"1000,1", "14000,14"})
    void count(Integer money, Integer count) {
        Amount amount = new Amount(money);
        assertThat(amount.getCount()).isEqualTo(count);
    }
}
