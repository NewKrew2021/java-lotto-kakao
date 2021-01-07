package lotto.domain;

import lotto.StatisticsType;
import lotto.domain.LottoLogic;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.*;

public class LottoLogicTest {

    @Test
    void lottoNosLengthValidTest() {
        List<LottoNos> lottoTickets = LottoLogic.makeRandomLottos(10);
        assertThat(lottoTickets.size()).isEqualTo(10);
    }

    @Test
    void statisticTest() {
        WinningLottoNos winningLottoNos = new WinningLottoNos(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        LottoNos lottoNos2 = new LottoNos(Arrays.asList(1, 2, 9, 10, 11, 12)); // 2
        LottoNos lottoNos3 = new LottoNos(Arrays.asList(1, 2, 3, 9, 10, 11)); // 3
        LottoNos lottoNos4 = new LottoNos(Arrays.asList(1, 2, 3, 4, 10, 11)); // 4
        LottoNos lottoNos5 = new LottoNos(Arrays.asList(1, 2, 3, 4, 5, 8)); // 5
        LottoNos lottoNos5_1 = new LottoNos(Arrays.asList(1, 2, 3, 4, 5, 7)); // 5,1
        LottoNos lottoNos6 = new LottoNos(Arrays.asList(1, 2, 3, 4, 5, 6)); // 6

    }

    @Test
    void winningStatisticsTest() {
        WinningLottoNos winningLottoNos = new WinningLottoNos(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        List<LottoNos> lottoTickets = Arrays.asList(
                new LottoNos(Arrays.asList(1, 2, 9, 10, 11, 12))
                , new LottoNos(Arrays.asList(1, 2, 3, 9, 10, 11))
                , new LottoNos(Arrays.asList(1, 2, 3, 4, 10, 11))
                , new LottoNos(Arrays.asList(1, 2, 3, 4, 5, 8))
                , new LottoNos(Arrays.asList(1, 2, 3, 4, 5, 7))
                , new LottoNos(Arrays.asList(1, 2, 3, 4, 5, 6))
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
