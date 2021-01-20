package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.*;

@DisplayName("당첨 로또 번호 테스트")
public class WinningLottoNosTest {

    @ParameterizedTest
    @CsvSource(
            "'1,2,3,4,5,6'," +
            "'7'," +
            "'1,2,9,10,11,12|1,2,3,9,10,11|1,2,3,4,8,9|1,2,3,4,5,8|1,2,3,4,5,7|1,2,3,4,5,6'"
    )
    @DisplayName("로또 티켓과 당첨 로또 번호에 따라 통계 결과가 정확히 기록되는지 테스트")
    void isWinningTest(String winningLottoNumbers, int bonusNumber, String ticketsNumbers) {
        WinningLottoNos winningLottoNos = new WinningLottoNos(CsvParsing.convertStringToIntegerSet(winningLottoNumbers), bonusNumber);
        List<LottoTicket> lottoTickets = new ArrayList<>();
        List<Set<Integer>> ticketsNumberListInt = CsvParsing.convertStringToTicketsNumber(ticketsNumbers);

        for( Set<Integer> ticket : ticketsNumberListInt ) {
            lottoTickets.add(new LottoTicket(ticket));
        }

        StatisticsType none = winningLottoNos.rankWinning(lottoTickets.get(0));
        StatisticsType three = winningLottoNos.rankWinning(lottoTickets.get(1));
        StatisticsType four = winningLottoNos.rankWinning(lottoTickets.get(2));
        StatisticsType five = winningLottoNos.rankWinning(lottoTickets.get(3));
        StatisticsType fiveWithBonus = winningLottoNos.rankWinning(lottoTickets.get(4));
        StatisticsType six = winningLottoNos.rankWinning(lottoTickets.get(5));

        assertThat(none).isEqualTo(StatisticsType.NONE);
        assertThat(three).isEqualTo(StatisticsType.THREE);
        assertThat(four).isEqualTo(StatisticsType.FOUR);
        assertThat(five).isEqualTo(StatisticsType.FIVE);
        assertThat(fiveWithBonus).isEqualTo(StatisticsType.FIVE_WITH_BONUS);
        assertThat(six).isEqualTo(StatisticsType.SIX);
    }

    @ParameterizedTest
    @CsvSource(
            "'1,2,3,4,5,6'," + "'7'," +
            "'7,8,9,10,11,12|6,7,8,9,10,11|5,6,7,8,9,10|4,5,6,7,8,9|3,4,5,6,7,8|2,3,4,5,6,7|1,2,3,4,5,6'"
    )
    @DisplayName("로또 번호와 당첨 로또간 번호 일치 갯수가 정확히 판단되는지 테스트")
    void matchTicketTest(String ticketNumbers, int bonusNumber, String ticketsNumbers){
        WinningLottoNos winningTicket = new WinningLottoNos(CsvParsing.convertStringToIntegerSet(ticketNumbers) , bonusNumber);
        List<LottoTicket> lottoTickets = new ArrayList<>();
        List<Set<Integer>> ticketsNumberListInt = CsvParsing.convertStringToTicketsNumber(ticketsNumbers);

        for( Set<Integer> ticket : ticketsNumberListInt ) {
            lottoTickets.add(new LottoTicket(ticket));
        }

        for (int i = 0; i < 7; i++) {
            int matchCount = winningTicket.matchTickets(lottoTickets.get(i));
            assertThat(matchCount).isEqualTo(i);
        }
    }

}
