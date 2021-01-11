package lotto;

import lotto.domain.PurchaseMoney;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PurchaseMoneyTest {
    @Test
    @DisplayName("PurchaseMoney 생성 테스트")
    void createTest() {
        PurchaseMoney purchaseMoney = new PurchaseMoney("2000");
        assertThat(purchaseMoney).isEqualTo(new PurchaseMoney("2000"));
    }

    @ParameterizedTest
    @CsvSource({"1500", "-1000"})
    @DisplayName("PurchaseMoney에 유효한 값이 입력되지 않는 경우 예외 발생")
    void inputTest(String moneyText) {
        assertThatThrownBy(() -> new PurchaseMoney(moneyText)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구매 개수 테스트")
    void quantityTest() {
        PurchaseMoney purchaseMoney = new PurchaseMoney("2000");
        assertThat(purchaseMoney.getLottoQuantity()).isEqualTo(2);
    }

    @ParameterizedTest
    @CsvSource({"1000,2", "1000,-1"})
    @DisplayName("수동 구매 개수에 유효한 값이 입력되지 않는 경우 예외 발생")
    void checkManualQuantityTest(String moneyText, int manualQuantity) {
        assertThatThrownBy(() -> new PurchaseMoney(moneyText).checkManualQuantity(manualQuantity))
                .isInstanceOf(IllegalArgumentException.class);
    }
}