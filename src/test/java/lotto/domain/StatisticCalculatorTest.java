package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StatisticCalculatorTest {

    List<RankState> eachLottoResult;
    Money money;
    StatisticCalculator statCalculator;

    @BeforeEach
    void setUp() {
        eachLottoResult = new ArrayList<>(Arrays.asList(
                RankState.FAIL, RankState.THIRD, RankState.FAIL, RankState.FAIL, RankState.FOURTH, RankState.FIRST
        ));
        money = new Money(14000);
        statCalculator = new StatisticCalculator(eachLottoResult, money);
    }

    @Test
    public void create() {
        assertThat(statCalculator).isEqualTo(new StatisticCalculator(eachLottoResult, money));
    }

    @Test
    public void eachRankCount() {
        List<Integer> rankCount = new ArrayList<>(Arrays.asList(3, 0, 1, 1, 0, 1));
        assertThat(statCalculator.getRankCount()).isEqualTo(rankCount);
    }

    @Test
    public void profitRate() {
        double expectedProfitRate = 2001550000.0 / 14000.0;
        assertThat(statCalculator.getProfitRate()).isEqualTo(expectedProfitRate);
    }
}
