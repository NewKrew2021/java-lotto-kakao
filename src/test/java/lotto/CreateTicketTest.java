package lotto;

import lotto.domain.CreateTicket;
import lotto.domain.InvalidHandTicketSizeException;
import lotto.domain.InvalidPriceException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;


public class CreateTicketTest {
    private List<String> ticket;


    @ParameterizedTest
    @ValueSource(ints = {2, 5, 10})
    void createTotalTicketCountTest(int ticketCount){
        ticket = IntStream.rangeClosed(1, ticketCount)
                .mapToObj(val -> "1, 2, 3, 4, 5, 6")
                .collect(Collectors.toList());
        assertThat(CreateTicket.createTotalTicket(ticketCount*1000, ticket).size()).isEqualTo(ticketCount);
    }

    @Test
    void invalidPriceExceptionTest(){
        ticket = new ArrayList<String>(Arrays.asList("1, 2, 3, 4, 5, 6"));
        assertThatThrownBy(() -> {
            CreateTicket.createTotalTicket(500, ticket);
        }).isInstanceOf(InvalidPriceException.class);
    }

    @Test
    void invalidHandTicketSizeExceptionTest(){
        ticket = new ArrayList<String>(Arrays.asList("1,2,3,4,5,6", "1,2,3,4,5,6"));
        assertThatThrownBy(() -> {
            CreateTicket.createTotalTicket(1000, ticket);
        }).isInstanceOf(InvalidHandTicketSizeException.class);
    }

}
