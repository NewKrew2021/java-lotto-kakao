package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoRanksTest {

    @Test
    void testProfitRatio() {
        List<LottoRank> lottoRanksList= Arrays.asList(LottoRank.FIRST,LottoRank.SECOND,LottoRank.THIRD,LottoRank.NONE);
        LottoRanks lottoRanks=new LottoRanks(lottoRanksList);
        assertThat(lottoRanks.profitRatio()).isEqualTo(2031500000/4000);
    }

}
