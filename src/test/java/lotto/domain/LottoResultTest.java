package lotto.domain;

import lotto.domain.LottoResult;
import lotto.domain.PurchaseMoney;
import lotto.domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    @Test
    @DisplayName("LottoResult에 getRank 메소드를 통해 Rank 개수가 올바르게 반환되는지 확인한다.")
    void getRankTest() {
        LottoResult lottoResult = new LottoResult();
        lottoResult.addRank(Rank.FIRST);
        lottoResult.addRank(Rank.THIRD);
        assertThat(lottoResult.getRankCount(Rank.FIRST)).isEqualTo(1);
        assertThat(lottoResult.getRankCount(Rank.SECOND)).isEqualTo(0);
        assertThat(lottoResult.getRankCount(Rank.THIRD)).isEqualTo(1);
    }

    @Test
    @DisplayName("LottoResult에 추가된 당첨결과에 따라 상금을 올바르게 구하는지 확인한다.")
    void getPrizeTest() {
        LottoResult lottoResult = new LottoResult();
        lottoResult.addRank(Rank.FIRST);
        lottoResult.addRank(Rank.SECOND);
        lottoResult.addRank(Rank.THIRD);
        assertThat(lottoResult.getPrize()).isEqualTo(2031500000);
    }

    @Test
    @DisplayName("수익률을 올바르게 구하는지 확인한다.")
    void getProfitRatioTest() {
        LottoResult lottoResult = new LottoResult();
        lottoResult.addRank(Rank.FIFTH);
        PurchaseMoney purchaseMoney = new PurchaseMoney(9000);
        assertThat(lottoResult.getProfitRatio(purchaseMoney)).isEqualTo("55.56");
    }
}
