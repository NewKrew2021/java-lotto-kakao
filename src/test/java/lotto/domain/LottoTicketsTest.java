package lotto.domain;

import lotto.domain.strategy.RandomTicketStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

public class LottoTicketsTest {
    @Test
    @DisplayName("팩토리 메소드 테스트")
    void lottoTicketCountTest(){
        LottoTickets lottoTickets = LottoTickets.from(new RandomTicketStrategy(), 14);
        assertThat(lottoTickets.getTicketCount()).isEqualTo(14);
    }

    @Test
    @DisplayName("Ticket 병합 테스트")
    void joinTicketTest() {
        List<LottoTicket> firstTicketsList = new ArrayList<>();
        firstTicketsList.add(LottoTicket.from("1, 2, 3, 4, 5, 6"));
        LottoTickets lottoTickets = new LottoTickets(firstTicketsList);

        List<LottoTicket> secondTicketList = new ArrayList<>();
        secondTicketList.add(LottoTicket.from("1, 2, 3, 4, 5, 6"));
        LottoTickets joinedLottoTickets = new LottoTickets(secondTicketList);

        List<LottoTicket> joinedList = new ArrayList<>();
        joinedList.addAll(firstTicketsList);
        joinedList.addAll(secondTicketList);
        assertThat(LottoTickets.join(lottoTickets, joinedLottoTickets)).isEqualTo(new LottoTickets(joinedList));
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

    @Test
    @DisplayName("toString 테스트")
    void toStringTest() {
        LottoTickets lottoTickets = LottoTickets.from(() -> {
            return new TreeSet<>(Arrays.asList(Number.of(1), Number.of(2), Number.of(3), Number.of(4), Number.of(5), Number.of(6)));
        }, 1);
        assertThat(lottoTickets.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]\n");
    }
}
