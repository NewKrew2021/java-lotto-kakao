package lotto.domain.game;

import lotto.domain.game.LottoRevenue;
import lotto.domain.ranking.LottoRanking;
import lotto.domain.ranking.LottoRankingCount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoRevenueTest {
    @DisplayName("랭킹과 랭킹카운트가 주어지면 그에 따른 총 수익을 구한다.")
    @Test
    void create() {
        //given
        Map<LottoRanking, Integer> rankingCount = new HashMap<>();
        rankingCount.put(LottoRanking.RANK_4,1);
        rankingCount.put(LottoRanking.RANK_5,2);

        //when
        LottoRevenue lottoRevenue = new LottoRevenue(rankingCount);

        //then
        assertThat(lottoRevenue.getRevenue()).isEqualTo(60000);
    }


}
