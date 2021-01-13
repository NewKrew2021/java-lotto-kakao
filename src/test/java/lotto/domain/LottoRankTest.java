package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoRankTest {

    @Test
    @DisplayName("일치하는 번호에 따른 등수 확인")
    void testCheckRanking() {
        LottoRank rank = LottoRank.checkRanking(6, 0);
        assertThat(rank).isEqualTo(LottoRank.FIRST);
        rank = LottoRank.checkRanking(5, 1);
        assertThat(rank).isEqualTo(LottoRank.SECOND);
    }
}
