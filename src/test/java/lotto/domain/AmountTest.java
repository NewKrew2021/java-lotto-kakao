package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class AmountTest {

    @Test
    public void testAmountValidation() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> new Amount(999));
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> new Amount(-1));
    }

    @Test
    public void testBuyCount() {
        Assertions.assertTrue(new Amount(1999).BuyCount() == 1);
        Assertions.assertTrue(new Amount(2000).BuyCount() == 2);
        Assertions.assertTrue(new Amount(2999).BuyCount() == 2);
        Assertions.assertTrue(new Amount(3000).BuyCount() == 3);
    }
}
