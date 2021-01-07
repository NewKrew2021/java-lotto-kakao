package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PurchaseMoneyTest {

    @Test
    void createTest() {
        PurchaseMoney purchaseMoney = new PurchaseMoney(2000);
        assertThat(purchaseMoney).isEqualTo(new PurchaseMoney(2000));
    }

    @Test
    void inputTest() {
        PurchaseMoney purchaseMoney = new PurchaseMoney(2000);

        assertThatThrownBy(() -> {
           new PurchaseMoney(1500);
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            new PurchaseMoney(-1000);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void amountTest() {
        PurchaseMoney purchaseMoney = new PurchaseMoney(2000);
        assertThat(purchaseMoney.getLottoAmount()).isEqualTo(2);
    }

}
