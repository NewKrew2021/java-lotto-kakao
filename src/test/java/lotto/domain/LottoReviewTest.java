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
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto(Arrays.asList(
                LottoNumber.makeNumber(1),
                LottoNumber.makeNumber(2),
                LottoNumber.makeNumber(3),
                LottoNumber.makeNumber(4),
                LottoNumber.makeNumber(5),
                LottoNumber.makeNumber(6))));

        lottos = new Lottos(lottoList);
        wonLotto = new WonLotto(new Lotto(Arrays.asList(
                LottoNumber.makeNumber(1),
                LottoNumber.makeNumber(2),
                LottoNumber.makeNumber(3),
                LottoNumber.makeNumber(4),
                LottoNumber.makeNumber(5),
                LottoNumber.makeNumber(6))), 7);
        lottoReview = new LottoReview(lottos, wonLotto);

    }

    @Test
    void testSameCount(){
        assertThat(lottoReview.getSameCountList().get(0)).isEqualTo(1);
        assertThat(lottoReview.getSameCountList().get(2)).isEqualTo(0);
    }

    @Test
    void testLottoProfit() {
        assertThat(lottoReview.getProfit()).isEqualTo(LottoRank.FIRST.getMoney());
    }

    @Test
    void testLottoProfitRatio(){
        Lottos lottos = new Lottos();
        assertThat(lottoReview.getProfitRatio()).isEqualTo(LottoRank.FIRST.getMoney()/10);
    }

}
