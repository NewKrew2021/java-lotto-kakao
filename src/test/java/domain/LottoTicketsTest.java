package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LottoTicketsTest {

  LottoTicket ticket1;
  LottoTicket ticket2;
  LottoTicket ticket3;
  LottoTickets lottoTickets;

  @BeforeEach
  void setUp() {
    ticket1 = LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 6));
    ticket2 = LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 7));
    ticket3 = LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 8));
    lottoTickets = new LottoTickets(Arrays.asList(ticket1, ticket2, ticket3));
  }

  @Test
  void create() {
    assertThat(lottoTickets.size()).isEqualTo(3);
    assertThat(lottoTickets).isEqualTo(new LottoTickets(Arrays.asList(ticket1, ticket2, ticket3)));
  }

  @Test
  void rank() {
    LottoWinningNumber lottoWinningNumber = new LottoWinningNumber(
        LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 6)), LottoNumber.of(7));
    WinningInfo winningInfo = lottoTickets.getWinningInfo(lottoWinningNumber);

    Map<LottoRank, Integer> testWinningInfo = new HashMap<>();
    testWinningInfo.put(LottoRank.FIRST, 1);
    testWinningInfo.put(LottoRank.SECOND, 1);
    testWinningInfo.put(LottoRank.THIRD, 1);

    assertThat(winningInfo).isEqualTo(new WinningInfo(testWinningInfo));
  }
}
