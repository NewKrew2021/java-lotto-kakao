package domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketsTest {

    @Test
    public void create(){
        LottoTicket ticket1 = LottoTicket.ofIntegerNumber(Arrays.asList(1,2,3,4,5,6));
        LottoTicket ticket2 = LottoTicket.ofIntegerNumber(Arrays.asList(1,2,3,4,5,7));
        LottoTicket ticket3 = LottoTicket.ofIntegerNumber(Arrays.asList(1,2,3,4,5,8));
        LottoTickets tickets = new LottoTickets(Arrays.asList(ticket1, ticket2, ticket3));
        assertThat(tickets.size()).isEqualTo(3);
    }

}
