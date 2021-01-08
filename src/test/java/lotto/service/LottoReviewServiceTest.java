package lotto.service;

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
        wonLotto = new WonLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), 7);
        lottoReviewService = new LottoReviewService();

    }


    @Test
    void testLottoProfit() {

        Lottos lottos = new Lottos();
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)));
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 10)));
        lottos.add(new Lotto(Arrays.asList(7, 9, 5, 42, 24, 21)));

        assertThat(lottoReviewService.getProfit(lottos.lottosResult(wonLotto))).isEqualTo(2031500000);
    }

    @Test
    void testLottoProfitRatio() {
        Lottos lottos = new Lottos();
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)));
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 10)));
        lottos.add(new Lotto(Arrays.asList(7, 9, 5, 42, 24, 21)));

        assertThat(lottoReviewService.getProfitRatio(lottos.lottosResult(wonLotto))).isEqualTo(50787500);
    }

}
