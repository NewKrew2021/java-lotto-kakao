package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoReviewTest {

    private WonLotto wonLotto;
    private  LottoReview lottoReview;
    @BeforeEach
    void setUp() {
        wonLotto = new WonLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), 7);
        lottoReview = new LottoReview();

    }


    @Test
    void testLottoProfit() {

        Lottos lottos = new Lottos();
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)));
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 10)));
        lottos.add(new Lotto(Arrays.asList(7, 9, 5, 42, 24, 21)));

        assertThat(lottoReview.getProfit(lottos.lottosResult(wonLotto))).isEqualTo(2031500000);
    }

    @Test
    void testLottoProfitRatio(){
        Lottos lottos = new Lottos();
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)));
        lottos.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 10)));
        lottos.add(new Lotto(Arrays.asList(7, 9, 5, 42, 24, 21)));

        assertThat(lottoReview.getProfitRatio(lottos.lottosResult(wonLotto))).isEqualTo(50787500);
    }

}
