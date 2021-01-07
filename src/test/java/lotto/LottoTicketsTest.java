package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoTicketsTest {

    @DisplayName("로또 티켓들이 주어지면 로또 티켓 일급 컬렉션을 생성한다.")
    @Test
    void create() {
        //given
        NumberGenerateStrategy strategy = new OneToSixGenerator();
        List<LottoTicket> given = Arrays.asList(
                LottoTicket.from(strategy),
                LottoTicket.from(strategy),
                LottoTicket.from(strategy),
                LottoTicket.from(strategy)
        );

        //when
        LottoTickets lottoTickets = new LottoTickets(given);

        //then
        assertThat(lottoTickets.getLottoTickets()).isEqualTo(given);
    }
}
