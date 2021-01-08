package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTableTest {

    @Test
    void getRankTest() {
        assertThat(RankTable.get(new MatchResult(6, false))).isEqualTo(LottoRank.FIRST);
        assertThat(RankTable.get(new MatchResult(5, true))).isEqualTo(LottoRank.SECOND);
        assertThat(RankTable.get(new MatchResult(5, false))).isEqualTo(LottoRank.THIRD);
        assertThat(RankTable.get(new MatchResult(4, false))).isEqualTo(LottoRank.FOURTH);
        assertThat(RankTable.get(new MatchResult(3, false))).isEqualTo(LottoRank.FIFTH);

        assertThat(new MatchResult(4, true).hashCode()).isEqualTo(new MatchResult(4, false).hashCode());
        assertThat(RankTable.get(new MatchResult(4, true))).isEqualTo(LottoRank.FOURTH);
        assertThat(RankTable.get(new MatchResult(3, true))).isEqualTo(LottoRank.FIFTH);
    }
}
