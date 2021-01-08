package lotto;

import lotto.domain.PurchaseMoney;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PurchaseMoneyTest {
    @Test
    void createTest() {
        PurchaseMoney purchaseMoney = new PurchaseMoney("2000");
        assertThat(purchaseMoney).isEqualTo(new PurchaseMoney("2000"));
    }

    @ParameterizedTest
    @CsvSource({"1500", "-1000"})
    void inputTest(String moneyString) {
        assertThatThrownBy(() -> new PurchaseMoney(moneyString)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void amountTest() {
        PurchaseMoney purchaseMoney = new PurchaseMoney("2000");
        assertThat(purchaseMoney.getLottoAmount()).isEqualTo(2);
    }
}