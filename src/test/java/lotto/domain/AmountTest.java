package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class AmountTest {

    @Test
    public void testAmountValidation() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> new Amount(999));
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> new Amount(-1));
    }

    @Test
    public void testBuyCount() {
        Assertions.assertTrue(new Amount(1999).BuyCount() == 1);
        Assertions.assertTrue(new Amount(2000).BuyCount() == 2);
        Assertions.assertTrue(new Amount(2999).BuyCount() == 2);
        Assertions.assertTrue(new Amount(3000).BuyCount() == 3);
    }

    @Test
    void testProfitRatio() {
        List<LottoRank> lottoRanksList = Arrays.asList(LottoRank.FIRST, LottoRank.SECOND, LottoRank.THIRD, LottoRank.NONE);
        LottoResult lottoResult = new LottoResult(lottoRanksList);
        Amount amount = new Amount(4000);
        assertThat(amount.profitRatio(lottoResult.totalPrize())).isEqualTo(new BigDecimal(2031500000 / 4000).setScale(2, BigDecimal.ROUND_HALF_UP));
    }
}
