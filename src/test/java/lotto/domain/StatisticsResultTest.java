package lotto.domain;

import lotto.StatisticsType;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.*;

public class StatisticsResultTest {

    @Test
    void benefitTest() {
        StatisticsResult statisticsResult = new StatisticsResult();
        statisticsResult.increaseTypeCount(StatisticsType.NONE);
        statisticsResult.increaseTypeCount(StatisticsType.THREE);
        statisticsResult.increaseTypeCount(StatisticsType.FOUR);
        statisticsResult.increaseTypeCount(StatisticsType.FIVE);
        statisticsResult.increaseTypeCount(StatisticsType.FIVE_WITH_BONUS);
        statisticsResult.increaseTypeCount(StatisticsType.SIX);

        assertThat(statisticsResult.getYield())
                .isGreaterThan(338592)
                .isLessThan(338593);
    }

}
