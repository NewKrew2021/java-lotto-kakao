package lotto;

import lotto.domain.LottoResult;
import lotto.domain.PurchaseMoney;
import lotto.domain.Rank;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
    @Test
    void getPrizeTest() {
        LottoResult lottoResult = new LottoResult();
        lottoResult.addRank(Rank.FIRST);
        lottoResult.addRank(Rank.SECOND);
        lottoResult.addRank(Rank.THIRD);
        assertThat(lottoResult.getPrize()).isEqualTo(2031500000);
    }

    @Test
    void getProfitRatioTest() {
        LottoResult lottoResult = new LottoResult();
        lottoResult.addRank(Rank.FIFTH);
        PurchaseMoney purchaseMoney = new PurchaseMoney("9000");
        assertThat(lottoResult.getProfitRatio(purchaseMoney)).isEqualTo("55.56");
    }
}
