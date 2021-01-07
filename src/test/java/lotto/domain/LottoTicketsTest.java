package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

//import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoTicketsTest {

    @Test
    public void testGenerateTickets(){
        LottoTickets tickets = new LottoTickets(2);
        LottoNumbers[] numbers = new LottoNumbers[2];
        numbers[0] = new LottoNumbers(new HashSet<Integer>(Arrays.asList(1,2,3,4,5,6)));
        numbers[0] = new LottoNumbers(new HashSet<Integer>(Arrays.asList(3,4,7,8,9,10)));

        tickets.generateTickets(numbers);

        assertThat(tickets.getTickets()).contains(
                new LottoTicket(numbers[0]),
                new LottoTicket(numbers[1])
                );
    }

    @Test
    public void testMethod(){
        assertThat(true).isEqualTo(true);
    }
}


