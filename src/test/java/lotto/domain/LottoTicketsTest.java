package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

public class LottoTicketsTest {
    @Test
    @DisplayName("가격에 따른 티켓 갯수 테스트")
    void lottoTicketCountTest(){
        LottoTickets lottoTickets = LottoTickets.from(new PurchaseInformation(14000, 0), new ArrayList<String>());
        assertThat(lottoTickets.getTicketCount()).isEqualTo(14);

        List<String> manualNumbers = Arrays.asList("1,2,3,4,5,6", "2,3,4,5,6,7");
        lottoTickets = LottoTickets.from(new PurchaseInformation(5500, 2), manualNumbers);
        assertThat(lottoTickets.getTicketCount()).isEqualTo(5);
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
    @DisplayName("수동 티켓 생성 테스트")
    void makeManualTicketTest() {
        PurchaseInformation purchase = new PurchaseInformation(2000, 2);
        List<String> manualNumbers = Arrays.asList("1,2,3,4,5,6", "11, 12, 13, 14, 15, 16");
        LottoTickets lottoTickets = LottoTickets.from(purchase, manualNumbers);

        List<LottoTicket> lottoTicketList = new ArrayList<>();
        manualNumbers.forEach(numbers -> lottoTicketList.add(LottoTicket.from(numbers)));
        assertThat(lottoTickets).isEqualTo(new LottoTickets(lottoTicketList));
    }

    @Test
    @DisplayName("toString 테스트")
    void toStringTest() {
        PurchaseInformation purchase = new PurchaseInformation(1000, 1);
        List<String> manualNumbers = Arrays.asList("1,2,3,4,5,6");
        LottoTickets lottoTickets = LottoTickets.from(purchase, manualNumbers);
        assertThat(lottoTickets.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]\n");
    }
}
