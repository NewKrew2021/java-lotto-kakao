package lotto;

import lotto.domain.LottoTickets;
import lotto.domain.CreateTicket;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class CreateTicketTest {
    @Test
    void allocateTicketTest(){
        CreateTicket makeTicket = new CreateTicket(14000);
        assertThat(makeTicket.allocateTicket()).
                isEqualTo(new LottoTickets(makeTicket.allocateTicket()).getLottoTickets());
    }
}
