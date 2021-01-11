package lotto.service;

import lotto.domain.LottoNumber;
import lotto.service.LottoReviewService;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.WonLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoReviewServiceTest {

    private WonLotto wonLotto;
    private LottoReviewService lottoReviewService;

    @BeforeEach
    void setUp() {
        wonLotto = new WonLotto(new Lotto(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6))), new LottoNumber(7));
        lottoReviewService = new LottoReviewService();

    }


    @Test
    void testLottoProfit() {

        Lottos lottos = new Lottos();
        lottos.add(new Lotto(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6))));
        lottos.add(new Lotto(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(7))));
        lottos.add(new Lotto(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(10))));
        lottos.add(new Lotto(Arrays.asList(new LottoNumber(7), new LottoNumber(9), new LottoNumber(5), new LottoNumber(42), new LottoNumber(24), new LottoNumber(21))));

        assertThat(lottoReviewService.getProfit(lottos.lottosResult(wonLotto))).isEqualTo(2031500000);
    }

    @Test
    void testLottoProfitRatio() {

        Lottos lottos = new Lottos();
        lottos.add(new Lotto(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6))));
        lottos.add(new Lotto(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(7))));
        lottos.add(new Lotto(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(10))));
        lottos.add(new Lotto(Arrays.asList(new LottoNumber(7), new LottoNumber(9), new LottoNumber(5), new LottoNumber(42), new LottoNumber(24), new LottoNumber(21))));
        double profitRatio=2031500000.0/4000.0;
        assertThat(lottoReviewService.getProfitRatio(lottos.lottosResult(wonLotto))).isEqualTo(profitRatio);
    }
    @Test
    void testLottoProfitRatioUnderOne() {

        Lottos lottos = new Lottos();
        lottos.add(new Lotto(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(7), new LottoNumber(8), new LottoNumber(9))));
        lottos.add(new Lotto(Arrays.asList(new LottoNumber(7), new LottoNumber(9), new LottoNumber(5), new LottoNumber(42), new LottoNumber(24), new LottoNumber(21))));
        lottos.add(new Lotto(Arrays.asList(new LottoNumber(7), new LottoNumber(9), new LottoNumber(5), new LottoNumber(42), new LottoNumber(24), new LottoNumber(21))));
        lottos.add(new Lotto(Arrays.asList(new LottoNumber(7), new LottoNumber(9), new LottoNumber(5), new LottoNumber(42), new LottoNumber(24), new LottoNumber(21))));

        assertThat(lottoReviewService.getProfitRatio(lottos.lottosResult(wonLotto))).isEqualTo(1.25);
    }

}
