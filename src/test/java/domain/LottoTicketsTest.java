package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class LottoTicketsTest {

  @Test
  public void create() {
    LottoTicket ticket1 = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
    LottoTicket ticket2 = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 7));
    LottoTicket ticket3 = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 8));
    LottoTickets tickets = new LottoTickets(Arrays.asList(ticket1, ticket2, ticket3));
    assertThat(tickets.size()).isEqualTo(3);
  }

}
