package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class PriceTest {

    @ParameterizedTest
    @CsvSource({"5000", "10000", "50000"})
    @DisplayName("Price 생성자 테스트")
    void priceTest(int pay) {
        Price price = new Price(pay);
        assertThat(price.getPrice()).isEqualTo(pay);
    }
}
