package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class StatisticCalculatorTest {

    List<RankState> eachLottoResult;
    Money money;

    @BeforeEach
    void setUp() {
        eachLottoResult = new ArrayList<>(Arrays.asList(
                RankState.FAIL, RankState.THIRD, RankState.FAIL, RankState.FAIL, RankState.FOURTH, RankState.FIRST
        ));
        money = new Money(14000);
    }

    @Test
    public void eachRankCount() {
        List<Integer> rankCount = new ArrayList<>(Arrays.asList(3, 0, 1, 1, 0, 1));
        assertThat(StatisticCalculator.getRankCount(eachLottoResult)).isEqualTo(rankCount);
    }

    @Test
    public void profitRate() {
        double expectedProfitRate = (2001550000.0 - 14000.0) / 14000.0;
        assertThat(StatisticCalculator.getProfitRate(eachLottoResult, money)).isEqualTo(expectedProfitRate);
    }
}
