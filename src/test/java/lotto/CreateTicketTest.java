package lotto;

import lotto.domain.CreateTicket;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;


public class CreateTicketTest {

    @ParameterizedTest
    @ValueSource(ints = {2, 5, 10})
    void createTotalTicketCountTest(int ticketCount){
        List<String> ticket = IntStream.rangeClosed(1, ticketCount)
                .mapToObj(val -> "1, 2, 3, 4, 5, 6")
                .collect(Collectors.toList());
        assertThat(CreateTicket.createTotalTicket(2000, ticket).size()).isEqualTo(ticketCount);
    }

}
