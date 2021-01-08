package lotto.domain;

import lotto.domain.*;
import lotto.domain.Number;
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
        lottoTicketList.add(new LottoTicket(makeNumberTreeSet(Arrays.asList(1, 2, 3, 4, 5, 6))));
        lottoTicketList.add(new LottoTicket(makeNumberTreeSet(Arrays.asList(1, 2, 3, 4, 5, 9))));
        lottoTicketList.add(new LottoTicket(makeNumberTreeSet(Arrays.asList(1, 2, 9, 4, 7, 6))));
        lottoTicketList.add(new LottoTicket(makeNumberTreeSet(Arrays.asList(4, 20, 35, 6, 1, 5))));
        LottoTickets lottoTickets = new LottoTickets(lottoTicketList);
        WinnerNumber winnerNumber = new WinnerNumber(makeNumberTreeSet(Arrays.asList(1, 2, 3, 4, 5, 6)), new lotto.domain.Number(9));
        LottoResults expectedResult = new LottoResults();
        expectedResult.upsert(LottoRank.FIRST);
        expectedResult.upsert(LottoRank.SECOND);
        expectedResult.upsert(LottoRank.FOURTH);
        expectedResult.upsert(LottoRank.FOURTH);
        assertThat(lottoTickets.getResults(winnerNumber)).isEqualTo(expectedResult);

    }

    private Set<lotto.domain.Number> makeNumberTreeSet(List<Integer> intNumbers) {
        Set<lotto.domain.Number> numbers = new TreeSet<>();
        for (int number : intNumbers) {
            numbers.add(new Number(number));
        }
        return numbers;
    }
}
