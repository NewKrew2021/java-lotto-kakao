package dto;

import domain.exceptions.InvalidAmountException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;
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

    @ParameterizedTest
    @ValueSource(strings = {"", "a"})
    @DisplayName("input이 숫자가 아니면 NumberFormatException을 던진다.")
    public void testInputIsNotNumber(String input){
        assertThatExceptionOfType(NumberFormatException.class)
                .isThrownBy(()->new Amount(Integer.parseInt(input)));
        assertThatExceptionOfType(NumberFormatException.class)
                .isThrownBy(()->new Amount(Integer.parseInt(input)));
    }

    @ParameterizedTest
    @CsvSource({"12345,12", "3456,3","1000,1"})
    @DisplayName("구입 금액에 맞는 로또 티켓 수를 반환한다.")
    public void testGetCount(int input, int count){
        Amount amount = new Amount(input);
        assertThat(amount.getCount()).isEqualTo(count);
    }
}