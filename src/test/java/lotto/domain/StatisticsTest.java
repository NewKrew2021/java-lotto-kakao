package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.TreeMap;

import static org.assertj.core.api.Assertions.assertThat;

public class StatisticsTest {

    @Test
    void getRankTest() {
        Map m = new TreeMap<>();
        m.put(Rank.FIRST, 3);
        Statistics statistics = new Statistics(new Rankings(m), new Money(10000));
        assertThat(statistics.getCountOfRank(Rank.FIRST)).isEqualTo(3);
    }

    @Test
    void profitTest() {
        Map m = new TreeMap<>();
        m.put(Rank.FIRST, 2);
        Statistics statistics = new Statistics(new Rankings(m), new Money(14000));
        assertThat(statistics.getProfitRate()).isEqualTo(28571428);
    }
}
