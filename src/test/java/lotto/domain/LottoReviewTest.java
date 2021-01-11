package lotto.domain;

import lotto.domain.Lotto;
import lotto.domain.LottoReview;
import lotto.domain.Lottos;
import lotto.domain.WonLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoReviewTest {

    private Lottos lottos;
    private WonLotto wonLotto;
    private LottoReview lottoReview;
    @BeforeEach
    void setUp() {
        List<Lotto> lotto_parers = new ArrayList<>();
        lotto_parers.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        lotto_parers.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)));
        lotto_parers.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 10)));
        lotto_parers.add(new Lotto(Arrays.asList(7, 9, 5, 42, 24, 21)));

        lottos = new Lottos(lotto_parers);
        wonLotto = new WonLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), 7);
        lottoReview = new LottoReview(lottos, wonLotto);

    }

    @Test
    void testSameCount(){
        assertThat(lottoReview.getSameCountList().get(0)).isEqualTo(1);
        assertThat(lottoReview.getSameCountList().get(2)).isEqualTo(1);
    }

    @Test
    void testLottoProfit() {
        assertThat(lottoReview.getProfit()).isEqualTo(2031500000);
    }

    @Test
    void testLottoProfitRatio(){
        Lottos lottos = new Lottos();
        assertThat(lottoReview.getProfitRatio()).isEqualTo(50787500);
    }

}
