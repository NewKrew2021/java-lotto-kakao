package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class PurchaseMoneyTest {
    @Test
    @DisplayName("PurchaseMoney 생성 테스트")
    void createTest() {
        String moneyText = "2000";

        PurchaseMoney purchaseMoney = new PurchaseMoney(moneyText);

        assertThat(purchaseMoney).isEqualTo(new PurchaseMoney(moneyText));
    }

    @ParameterizedTest
    @CsvSource({"1500", "-1000"})
    @DisplayName("PurchaseMoney에 유효한 값이 입력되지 않는 경우 예외 발생")
    void inputTest(String moneyText) {
        Throwable throwable = catchThrowable(() -> new PurchaseMoney(moneyText));

        assertThat(throwable).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구매 개수 테스트")
    void quantityTest() {
        String moneyText = "2000";
        PurchaseMoney purchaseMoney = new PurchaseMoney(moneyText);

        int lottoQuantity = purchaseMoney.getLottoQuantity();

        assertThat(lottoQuantity).isEqualTo(2);
    }

    @ParameterizedTest
    @CsvSource({"1000,2", "1000,-1"})
    @DisplayName("수동 구매 개수에 유효한 값이 입력되지 않는 경우 예외 발생")
    void checkManualQuantityTest(String moneyText, int manualQuantity) {
        PurchaseMoney purchaseMoney = new PurchaseMoney(moneyText);
        Throwable throwable = catchThrowable(() -> purchaseMoney.checkManualQuantity(manualQuantity));

        assertThat(throwable).isInstanceOf(IllegalArgumentException.class);
    }
}