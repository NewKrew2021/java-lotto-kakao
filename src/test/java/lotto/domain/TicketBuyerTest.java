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

public class TicketBuyerTest {
    @Test
    void testGetInsertPrice() {
        TicketBuyer ticketBuyer = new TicketBuyer(new Price(123), 0);
        assertThat(ticketBuyer.getPrice().getPrice()).isEqualTo(123L);
    }

    @Test
    void invalidInputsShouldThrowError() {
        assertThatThrownBy(() -> new TicketBuyer(new Price(1000), -1))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new TicketBuyer(new Price(1999), 2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("잔돈을 올바르게 반환하는지 확인")
    @ParameterizedTest
    @CsvSource({"0,0", "999,999", "1000,0", "1001,1"})
    void testGetChange(int price, int expected) {
        TicketBuyer ticketBuyer = new TicketBuyer(new Price(price), 0);
        assertThat(ticketBuyer.getChange()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({"0,0", "999,0", "1000,1000", "1001,1000"})
    void testGetInvestedMoney(int price, long expected) {
        TicketBuyer ticketBuyer = new TicketBuyer(new Price(price), 0);
        assertThat(ticketBuyer.getInvestedMoney()).isEqualTo(expected);
    }

    @Test
    void testGetTicketAmount() {
        TicketBuyer ticketBuyer = new TicketBuyer(new Price(8234), 5);
        assertThat(ticketBuyer.getTotalTicketAmount()).isEqualTo(8);
        assertThat(ticketBuyer.getManualCount()).isEqualTo(5);
        assertThat(ticketBuyer.getRandomCount()).isEqualTo(3);
    }

    @Test
    void testGetTickets() {
        List<LottoNumbers> numbers = Arrays.asList(
                new LottoNumbers(LottoNumberArray.asList(1, 2, 3, 4, 5, 6)),
                new LottoNumbers(LottoNumberArray.asList(1, 2, 3, 4, 5, 6)),
                new LottoNumbers(LottoNumberArray.asList(1, 2, 3, 4, 5, 6)));

        TicketBuyer ticketBuyer = new TicketBuyer(new Price(0), 0);
        ticketBuyer.issueTickets(new LottoTickets(numbers));

        assertThat(ticketBuyer.getLottoTickets()).isEqualTo(new LottoTickets(numbers));
    }
}
