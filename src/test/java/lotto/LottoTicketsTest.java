package lotto;

import lotto.domain.LottoTickets;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class LottoTicketsTest {
    @Test
    void constructorTest(){
        LottoTickets lottoTickets = new LottoTickets(14000);
        assertThat(lottoTickets.getTicketCount()).isEqualTo(14);
    }
}
