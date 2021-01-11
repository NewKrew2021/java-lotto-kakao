package domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class LottoTicketsTest {
    @Test
    void constructorTest(){
        LottoTickets lottoTickets = LottoTickets.of(14000);
        assertThat(lottoTickets.getTicketCount()).isEqualTo(14);
    }
}
