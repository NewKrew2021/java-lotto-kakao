package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class PurchaseInformationTest {

    @ParameterizedTest
    @CsvSource({"5000", "10000", "50000"})
    @DisplayName("가격 저장 테스트")
    void priceTest(int pay) {
        PurchaseInformation purchase = new PurchaseInformation(pay, 0);
        assertThat(purchase.getPrice()).isEqualTo(pay);
    }

    @ParameterizedTest
    @CsvSource({"5000,2,3", "10000,7,3", "50000,10,40"})
    @DisplayName("티켓 수 테스트")
    void countTicketTest(int price, int manualCount, int autoCount) {
        PurchaseInformation purchase = new PurchaseInformation(price, manualCount);
        assertThat(purchase.getManualCount()).isEqualTo(manualCount);
        assertThat(purchase.getAutoCount()).isEqualTo(autoCount);
    }

    @Test
    @DisplayName("가격 음수값 예외 테스트")
    void checkNegativePriceTest() {
        assertThatThrownBy(() -> new PurchaseInformation(-1000, 1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("가격보다 많은 수동 예외 테스트")
    void checkCountExceptionTest() {
        assertThatThrownBy(() -> new PurchaseInformation(3000, 4))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
