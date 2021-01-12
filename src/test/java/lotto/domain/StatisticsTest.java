package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.TreeMap;

import static org.assertj.core.api.Assertions.assertThat;

public class StatisticsTest {

    @Test
    @DisplayName("랭크에 입력된 수가 정상적으로 반환되는지 여부")
    void getRankTest() {
        Map m = new TreeMap<>();
        m.put(Rank.FIRST, 3);
        Statistics statistics = new Statistics(new Rankings(m), new Money(10000));
        assertThat(statistics.getCountOfRank(Rank.FIRST)).isEqualTo(3);
    }

    @Test
    @DisplayName("통계에 따른 수익률의 정확도 테스트")
    void profitTest() {
        Map m = new TreeMap<>();
        m.put(Rank.FIRST, 2);
        Statistics statistics = new Statistics(new Rankings(m), new Money(14000));
        assertThat(statistics.getProfitRate()).isEqualTo(28571428);
    }
}
