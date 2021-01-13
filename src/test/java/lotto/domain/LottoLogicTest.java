package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.*;

public class LottoLogicTest {

    @Test
    void buyingLottoNosCountTest() {
        List<LottoTicket> lottoTickets1 = LottoLogic.buyLottoTicketsAuto(1000);
        List<LottoTicket> lottoTickets10 = LottoLogic.buyLottoTicketsAuto(10000);
        List<LottoTicket> lottoTickets100 = LottoLogic.buyLottoTicketsAuto(100000);

        assertThat(lottoTickets1.size()).isEqualTo(1);
        assertThat(lottoTickets10.size()).isEqualTo(10);
        assertThat(lottoTickets100.size()).isEqualTo(100);
    }

    @ParameterizedTest
    @CsvSource(
            "'1,2,3,4,5,6'," + "'7'," +
            "'2,3,4,9,10,11|" + //THREE
            "1,2,3,9,10,11|" +  //THREE
            "1,2,3,4,10,11|" +  //FOUR
            "1,2,3,4,5,8|" +    //FIVE
            "1,2,3,4,5,7|" +    //FIVE_WITH_BONUS
            "1,2,3,4,5,6'"      //SIX
    )
    void winningStatisticsTest(String winningLottoNumbers, int bonusNumber, String tickets) {
        WinningLottoNos winningLottoNos = new WinningLottoNos(CsvParsing.convertStringToIntegerSet(winningLottoNumbers), bonusNumber);
        List<LottoTicket> lottoTickets = new ArrayList<>();
        List<Set<Integer>> ticketsNumbers = CsvParsing.convertStringToTicketsNumber(tickets);

        for( Set<Integer> ticket : ticketsNumbers ) {
            lottoTickets.add(new LottoTicket(ticket));
        }

        StatisticsResult statisticsResult = new StatisticsResult();
        statisticsResult.increaseTypeCount(StatisticsType.THREE);
        statisticsResult.increaseTypeCount(StatisticsType.THREE);
        statisticsResult.increaseTypeCount(StatisticsType.FOUR);
        statisticsResult.increaseTypeCount(StatisticsType.FIVE);
        statisticsResult.increaseTypeCount(StatisticsType.FIVE_WITH_BONUS);
        statisticsResult.increaseTypeCount(StatisticsType.SIX);

        assertThat(LottoLogic.winningStatistics(lottoTickets, winningLottoNos))
                .isEqualTo(statisticsResult);
    }

}
