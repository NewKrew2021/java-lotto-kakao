package lotto.dto;

import lotto.util.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankingsDtoTest {

    @Test
    @DisplayName("등수에 대한 당첨횟수를 추가한다.")
    void addRank() {
        RankingsDto rankingsDto = new RankingsDto();
        rankingsDto.addRank(Rank.FIRST);
        rankingsDto.addRank(Rank.FIRST);

        assertThat(rankingsDto.getRankings().get(Rank.FIRST)).isEqualTo(2);
    }
}
