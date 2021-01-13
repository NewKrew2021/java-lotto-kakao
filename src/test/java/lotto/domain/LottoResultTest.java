package lotto.domain;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    @Test
    void testProfitRatio() {
        List<LottoRank> lottoRanksList = Arrays.asList(LottoRank.FIRST, LottoRank.SECOND, LottoRank.THIRD, LottoRank.NONE);
        LottoResult lottoResult = new LottoResult(lottoRanksList);
        assertThat(lottoResult.profitRatio()).isEqualTo(new BigDecimal(2031500000 / 4000).setScale(2, BigDecimal.ROUND_HALF_UP));
    }

}
