package domain;

import domain.exceptions.InvalidAmountException;
import org.junit.jupiter.api.Test;

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
}
