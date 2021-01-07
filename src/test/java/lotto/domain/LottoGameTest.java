package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoGameTest {

    @Test
    public void testGetLottoTicketCount(){
        LottoGame game = new LottoGame();
        int count = game.getLottoTicketCount(14050);
        assertThat(count).isEqualTo(14);
    }

    @Test
    public void testMakeLottoTickets(){
        LottoGame game = new LottoGame();
        game.makeLottoTickets(5);
        assertThat(game.isAssignedTickets()).isTrue();
    }
}
