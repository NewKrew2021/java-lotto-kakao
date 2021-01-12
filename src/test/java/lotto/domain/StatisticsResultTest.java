package lotto.domain;

import lotto.StatisticsType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.*;

public class StatisticsResultTest {

    @ParameterizedTest
    @CsvSource(
            "'1,2,3,4,5,6'," +
            "'7'," +
            "'1,2,3,9,10,11|1,2,3,4,10,11|1,2,3,4,5,8|1,2,3,4,5,7|1,2,3,4,5,6'"
    )
    void benefitTest(String winningNumbers, int bonusNumber, String ticketsNumbers) {
        WinningLottoNos winningLottoNos = new WinningLottoNos(CsvParsing.convertStringToIntegerList(winningNumbers), bonusNumber);
        List<LottoTicket> lottoTickets = new ArrayList<>();
        List<List<Integer>> ticketsNumberListInt = CsvParsing.convertStringToTicketsNumber(ticketsNumbers);


        StatisticsResult statisticsResult = new StatisticsResult();
        statisticsResult.increaseTypeCount(StatisticsType.NONE);
        statisticsResult.increaseTypeCount(StatisticsType.THREE);
        statisticsResult.increaseTypeCount(StatisticsType.FOUR);
        statisticsResult.increaseTypeCount(StatisticsType.FIVE);
        statisticsResult.increaseTypeCount(StatisticsType.FIVE_WITH_BONUS);
        statisticsResult.increaseTypeCount(StatisticsType.SIX);

        assertThat(statisticsResult.benefit())
                .isGreaterThan(338592)
                .isLessThan(338593);
    }

}
