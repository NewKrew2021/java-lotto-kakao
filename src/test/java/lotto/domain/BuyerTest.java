package lotto.domain;

import lotto.domain.vo.Price;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BuyerTest {
    @Test
    void testGetInsertPrice() {
        Buyer buyer = new Buyer(new Price(123), 0);
        assertThat(buyer.getInsertPrice().getPrice()).isEqualTo(123L);
    }

    @Test
    void invalidInputsShouldThrowError() {
        assertThatThrownBy(() -> new Buyer(new Price(1000), -1))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new Buyer(new Price(1999), 2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("잔돈을 올바르게 반환하는지 확인")
    @ParameterizedTest
    @CsvSource({"0,0", "999,999", "1000,0", "1001,1"})
    void testGetChange(int price, int expected) {
        Buyer buyer = new Buyer(new Price(price), 0);
        assertThat(buyer.getChange()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"0,0", "999,0", "1000,1000", "1001,1000"})
    void testGetInvestedMoney(int price, long expected) {
        Buyer buyer = new Buyer(new Price(price), 0);
        assertThat(buyer.getInvestedMoney()).isEqualTo(expected);
    }

    @Test
    void testGetTicketAmount() {
        Buyer buyer = new Buyer(new Price(8234), 5);
        assertThat(buyer.getTotalTicketAmount()).isEqualTo(8);
        assertThat(buyer.getManualChooseTicketAmount()).isEqualTo(5);
        assertThat(buyer.getRandomChooseTicketAmount()).isEqualTo(3);
    }

    @Test
    void testGetTickets() {
        List<LottoNumbers> numbers = Arrays.asList(
                new LottoNumbers(LottoNumberArray.asList(1, 2, 3, 4, 5, 6)),
                new LottoNumbers(LottoNumberArray.asList(1, 2, 3, 4, 5, 6)),
                new LottoNumbers(LottoNumberArray.asList(1, 2, 3, 4, 5, 6)));

        Buyer buyer = new Buyer(new Price(0), 0);
        buyer.setLottoTickets(new LottoTickets(numbers));

        assertThat(buyer.getLottoTickets()).isEqualTo(new LottoTickets(numbers));
    }
}
