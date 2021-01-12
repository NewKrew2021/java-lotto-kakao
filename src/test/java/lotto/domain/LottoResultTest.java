package lotto.domain;

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

        long prize = lottoResult.getPrize();

        assertThat(prize).isEqualTo(2031500000);
    }

    @Test
    @DisplayName("수익률 테스트")
    void getProfitRatioTest() {
        LottoResult lottoResult = new LottoResult();
        lottoResult.addRank(Rank.FIFTH);
        PurchaseMoney purchaseMoney = new PurchaseMoney("1000");

        String profitRatio = lottoResult.getProfitRatio(purchaseMoney);

        assertThat(profitRatio).isEqualTo("400.00");
    }
}
