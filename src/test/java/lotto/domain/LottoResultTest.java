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

    @Test
    @DisplayName("combine 메서드를 통해 합쳐진 로또 결과가 제대로 구해졌는지 확인한다.")
    void combineLottoResultTest() {
        LottoResult lottoResult1 = new LottoResult();
        lottoResult1.addRank(Rank.FIRST);
        lottoResult1.addRank(Rank.SECOND);
        LottoResult lottoResult2 = new LottoResult();
        lottoResult2.addRank(Rank.SECOND);
        lottoResult2.addRank(Rank.THIRD);
        LottoResult combinedLottoResult = LottoResult.combine(lottoResult1, lottoResult2);
        assertThat(combinedLottoResult.getRankCount(Rank.FIRST)).isEqualTo(1);
        assertThat(combinedLottoResult.getRankCount(Rank.SECOND)).isEqualTo(2);
        assertThat(combinedLottoResult.getRankCount(Rank.THIRD)).isEqualTo(1);
    }
}
