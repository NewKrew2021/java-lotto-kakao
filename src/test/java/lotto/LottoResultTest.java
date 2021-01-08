package lotto;

import lotto.domain.LottoResult;
import lotto.domain.PurchaseMoney;
import lotto.domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
    @Test
    @DisplayName("당첨금 합계 테스트")
    void getPrizeTest() {
        LottoResult lottoResult = new LottoResult();
        lottoResult.addRank(Rank.FIRST);
        lottoResult.addRank(Rank.SECOND);
        lottoResult.addRank(Rank.THIRD);
        assertThat(lottoResult.getPrize()).isEqualTo(2031500000);
    }

    @Test
    @DisplayName("수익률 테스트")
    void getProfitRatioTest() {
        LottoResult lottoResult = new LottoResult();
        lottoResult.addRank(Rank.FIFTH);
        PurchaseMoney purchaseMoney = new PurchaseMoney("9000");
        assertThat(lottoResult.getProfitRatio(purchaseMoney)).isEqualTo("55.56");
    }
}
