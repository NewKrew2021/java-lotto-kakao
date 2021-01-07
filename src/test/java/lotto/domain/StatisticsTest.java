package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.TreeMap;

import static org.assertj.core.api.Assertions.assertThat;

public class StatisticsTest {
    Statistics statistics;
    @BeforeEach
    void setUp(){
        statistics = new Statistics();
    }

    @Test
    void toStringTest() {
        Map m = new TreeMap<>();
        m.put(Rank.FIRST,3);
        m.put(Rank.SECOND,0);
        m.put(Rank.THIRD,2);
        m.put(Rank.FOURTH,0);
        m.put(Rank.FIFTH,0);
        statistics = new Statistics(m);
        assertThat(statistics.toString())
                .isEqualTo("3개 일치 (5000원)- 0개\n" +
                        "4개 일치 (50000원)- 0개\n" +
                        "5개 일치 (1500000원)- 2개\n" +
                        "5개 일치, 보너스 볼 일치(30000000원)- 0개\n" +
                        "6개 일치 (2000000000원)- 3개\n");
    }

    @Test
    void getRankTest(){
        statistics.addRank(Rank.FIRST);
        statistics.addRank(Rank.FIRST);
        statistics.addRank(Rank.FIRST);
        assertThat(statistics.getRank(Rank.FIRST)).isEqualTo(3);
    }

    @Test
    void profitTest(){
        statistics.addRank(Rank.FIRST);
        statistics.addRank(Rank.FIRST);
        assertThat(statistics.getProfitRate(new Money(14000))).isEqualTo(28571428);
    }
}
