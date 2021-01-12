package lotto.domain;

import lotto.StatisticsType;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.*;

public class LottoLogicTest {

    @Test
    void winningStatisticsTest() {
        WinningLottoNos winningLottoNos = new WinningLottoNos(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        List<LottoNumbers> lottoTickets = Arrays.asList(
                new LottoNumbers(Arrays.asList(1, 2, 9, 10, 11, 12))
                , new LottoNumbers(Arrays.asList(1, 2, 3, 9, 10, 11))
                , new LottoNumbers(Arrays.asList(1, 2, 3, 4, 10, 11))
                , new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 8))
                , new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 7))
                , new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6))
        );
        StatisticsResult statisticsResult = new StatisticsResult();
        statisticsResult.increaseTypeCount(StatisticsType.NONE);
        statisticsResult.increaseTypeCount(StatisticsType.THREE);
        statisticsResult.increaseTypeCount(StatisticsType.FOUR);
        statisticsResult.increaseTypeCount(StatisticsType.FIVE);
        statisticsResult.increaseTypeCount(StatisticsType.FIVE_WITH_BONUS);
        statisticsResult.increaseTypeCount(StatisticsType.SIX);

        assertThat(LottoLogic.winningStatistics(lottoTickets, winningLottoNos))
                .isEqualTo(statisticsResult);

    }

}
