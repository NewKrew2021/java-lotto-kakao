package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class PurchaseInfoTest {

    @Test
    @DisplayName("PurchaseInfo 클래스에 올바른 입력이 주어졌을 때 정상적으로 생성되는지 확인한다.")
    void createTest() {
        PurchaseMoney purchaseMoney = new PurchaseMoney(10000);
        PurchaseInfo purchaseInfo = new PurchaseInfo(purchaseMoney, 3);
        assertThat(purchaseInfo).isEqualTo(new PurchaseInfo(purchaseMoney, 3));
    }

    @ParameterizedTest
    @DisplayName("수동 구매 수량에 음수가 입력되거나 구매 가능한 수량보다 더 많은 수량이 입력된 경우 예외가 발생한다.")
    @ValueSource(ints = {-1, 11})
    void checkManualAmountTest(int manualLottoAmount) {
        Assertions.assertThatThrownBy(() -> {
            PurchaseMoney purchaseMoney = new PurchaseMoney(10000);
            PurchaseInfo purchaseInfo = new PurchaseInfo(purchaseMoney, manualLottoAmount);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
