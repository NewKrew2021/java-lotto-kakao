package domain;

import domain.exceptions.InvalidAmountException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class AmountTest {

    @Test
    @DisplayName("Amount 객체 생성 테스트")
    public void create() {
        Amount amount = new Amount(1000);
        assertThat(amount).isEqualTo(new Amount(1000));
    }

    @Test
    @DisplayName("구입 금액이 1000 미만이면 InvalidAmountException을 던진다.")
    public void isInvalidAmount() {
        assertThatExceptionOfType(InvalidAmountException.class)
                .isThrownBy(() -> new Amount(999));
    }

    @Test
    @DisplayName("input이 숫자가 아니면 NumberFormatException을 던진다.")
    public void testInputIsNotNumber(){
        assertThatExceptionOfType(NumberFormatException.class)
                .isThrownBy(()->new Amount(Integer.parseInt("")));
        assertThatExceptionOfType(NumberFormatException.class)
                .isThrownBy(()->new Amount(Integer.parseInt("a")));
    }
}
