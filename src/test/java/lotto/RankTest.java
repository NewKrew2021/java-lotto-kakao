package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class RankTest {
    @Test
    void createTest() {
        assertThat(Rank.createRank(6, false)).isEqualTo(Rank.FIRST);
        assertThat(Rank.createRank(5, true)).isEqualTo(Rank.SECOND);
        assertThat(Rank.createRank(5, false)).isEqualTo(Rank.THIRD);
        assertThat(Rank.createRank(4, true)).isEqualTo(Rank.FOURTH);
    }
}
