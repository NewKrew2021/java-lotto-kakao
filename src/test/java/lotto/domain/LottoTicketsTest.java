package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

public class LottoTicketsTest {
    @Test
    @DisplayName("가격에 따른 티켓 갯수 테스트")
    void lottoTicketCountTest(){
        LottoTickets lottoTickets = LottoTickets.fromPrice(14000);
        assertThat(lottoTickets.getTicketCount()).isEqualTo(14);
    }

    @Test
    @DisplayName("구매한 티켓들의 총 등수 결과 테스트")
    void lottoTicketsResultTest() {
        List<LottoTicket> lottoTicketList = new ArrayList<>();
        lottoTicketList.add(LottoTicket.from("1, 2, 3, 4, 5, 6"));
        lottoTicketList.add(LottoTicket.from("1, 2, 3, 4, 5, 9"));
        lottoTicketList.add(LottoTicket.from("1, 2, 9, 4, 7, 6"));
        lottoTicketList.add(LottoTicket.from("4, 20, 35, 6, 1, 5"));
        LottoTickets lottoTickets = new LottoTickets(lottoTicketList);
        WinnerNumber winnerNumber = WinnerNumber.from("1, 2, 3, 4, 5, 6", 9);

        LottoResults expectedResult = new LottoResults();
        expectedResult.upsert(LottoRank.FIRST);
        expectedResult.upsert(LottoRank.SECOND);
        expectedResult.upsert(LottoRank.FOURTH);
        expectedResult.upsert(LottoRank.FOURTH);
        assertThat(lottoTickets.getResults(winnerNumber)).isEqualTo(expectedResult);

    }
}
