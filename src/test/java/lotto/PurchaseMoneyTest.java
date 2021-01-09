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
    void inputTest(String moneyString) {
        assertThatThrownBy(() -> new PurchaseMoney(moneyString)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구매 개수 테스트")
    void amountTest() {
        PurchaseMoney purchaseMoney = new PurchaseMoney("2000");
        assertThat(purchaseMoney.getLottoAmount()).isEqualTo(2);
    }
}