package lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

public class LottoTicketsTest {
    @Test
    void constructorTest(){
        LottoTickets lottoTickets = LottoTickets.fromPrice(14000);
        assertThat(lottoTickets.getTicketCount()).isEqualTo(14);
    }

    @Test
    void lottoTicketsResultTest() {
        List<LottoTicket> lottoTicketList = new ArrayList<>();
        lottoTicketList.add(new LottoTicket(makeNumberHashSet(Arrays.asList(1, 2, 3, 4, 5, 6))));
        lottoTicketList.add(new LottoTicket(makeNumberHashSet(Arrays.asList(1, 2, 3, 4, 5, 9))));
        lottoTicketList.add(new LottoTicket(makeNumberHashSet(Arrays.asList(1, 2, 9, 4, 7, 6))));
        lottoTicketList.add(new LottoTicket(makeNumberHashSet(Arrays.asList(4, 20, 35, 6, 1, 5))));
        LottoTickets lottoTickets = new LottoTickets(lottoTicketList);
        WinnerNumber winnerNumber = new WinnerNumber(makeNumberHashSet(Arrays.asList(1, 2, 3, 4, 5, 6)), new Number(9));
        LottoResults expectedResult = new LottoResults();
        expectedResult.upsert(LottoRank.FIRST);
        expectedResult.upsert(LottoRank.SECOND);
        expectedResult.upsert(LottoRank.FOURTH);
        expectedResult.upsert(LottoRank.FOURTH);
        assertThat(lottoTickets.getResults(winnerNumber)).isEqualTo(expectedResult);

    }

    private Set<Number> makeNumberHashSet(List<Integer> intNumbers) {
        Set<Number> numbers = new HashSet<>();
        for (int number : intNumbers) {
            numbers.add(new Number(number));
        }
        return numbers;
    }
}
