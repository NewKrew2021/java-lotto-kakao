package utils;

import lotto.domain.InsertPrice;
import lotto.utils.TicketCountCalculator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class TicketCountCalculatorTest {
    @ParameterizedTest
    @CsvSource({"0,0", "999,0", "1000,1", "1001,1", "5000,5"})
    void correctNumberOfTickets(int price, int expected) {
        InsertPrice insertPrice = new InsertPrice(price);
        assertThat(TicketCountCalculator.getNumberOfTickets(insertPrice))
                .isEqualTo(expected);
    }
}
