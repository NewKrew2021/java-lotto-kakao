package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoRankTest {

    @Test
    void getRankTest() {
        assertThat(LottoRank.get(new MatchResult(6, false))).isEqualTo(LottoRank.FIRST);
        assertThat(LottoRank.get(new MatchResult(5, true))).isEqualTo(LottoRank.SECOND);
        assertThat(LottoRank.get(new MatchResult(5, false))).isEqualTo(LottoRank.THIRD);
        assertThat(LottoRank.get(new MatchResult(4, false))).isEqualTo(LottoRank.FOURTH);
        assertThat(LottoRank.get(new MatchResult(3, false))).isEqualTo(LottoRank.FIFTH);

        assertThat(new MatchResult(4, true).hashCode()).isEqualTo(new MatchResult(4, false).hashCode());
        assertThat(LottoRank.get(new MatchResult(4, true))).isEqualTo(LottoRank.FOURTH);
        assertThat(LottoRank.get(new MatchResult(3, true))).isEqualTo(LottoRank.FIFTH);
    }
}
