package lotto.dto;

import lotto.domain.Rank;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RankingsDtoTest {

    @Test
    void addRank() {
        RankingsDto rankingsDto = new RankingsDto();
        rankingsDto.addRank(Rank.FIRST);
        rankingsDto.addRank(Rank.FIRST);

        assertThat(rankingsDto.getRankings().get(Rank.FIRST)).isEqualTo(2);
    }
}