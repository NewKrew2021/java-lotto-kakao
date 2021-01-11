package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.TreeMap;

import static org.assertj.core.api.Assertions.assertThat;

public class StatisticsTest {

    @Test
    void getRankTest() {
        Map m = new TreeMap<>();
        m.put(Rank.FIRST, 3);
        Statistics statistics = new Statistics(m);
        assertThat(statistics.getRank(Rank.FIRST)).isEqualTo(3);
    }

    @Test
    void profitTest() {
        Map m = new TreeMap<>();
        m.put(Rank.FIRST, 2);
        Statistics statistics = new Statistics(m);
        assertThat(statistics.getProfitRate(new Money(14000))).isEqualTo(28571428);
    }
}
