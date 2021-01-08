package lotto.domain;

import lotto.domain.PurchaseMoney;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PurchaseMoneyTest {

    @Test
    @DisplayName("PurchaseMoney 클래스에 올바른 입력이 주어졌을 때 정상적으로 생성되는지 확인한다.")
    void createTest() {
        PurchaseMoney purchaseMoney = new PurchaseMoney(2000);
        assertThat(purchaseMoney).isEqualTo(new PurchaseMoney(2000));
    }

    @ParameterizedTest
    @DisplayName("PurchaseMoney 클래스에 잘못된 입력이 주어졌을 때 예외가 발생하는지 확인한다.")
    @ValueSource(ints = {1500, -1000})
    void inputTest(int money) {
        assertThatThrownBy(() -> {
            new PurchaseMoney(money);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("금액에 따라 올바르게 구매 수량이 구해지는지 확인한다.")
    void amountTest() {
        PurchaseMoney purchaseMoney = new PurchaseMoney(2000);
        assertThat(purchaseMoney.getLottoAmount()).isEqualTo(2);
    }
}