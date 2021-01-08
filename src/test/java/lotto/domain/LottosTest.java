package lotto.domain;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.Lottos;
import lotto.domain.WonLotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    private WonLotto wonLotto;

    @BeforeEach
    void setUp(){
        wonLotto = new WonLotto(new Lotto(Arrays.asList(1,2,3,4,5,6)), 7);
    }


    @Test
    void testLottoPrize(){

        Lottos lottos=new Lottos();
        lottos.add(new Lotto(Arrays.asList(1,2,3,4,5,6)));
        lottos.add(new Lotto(Arrays.asList(1,2,3,4,5,7)));
        lottos.add(new Lotto(Arrays.asList(1,2,3,4,5,10)));
        lottos.add(new Lotto(Arrays.asList(7,9,5,42,24,21)));

        assertThat(Arrays.asList(LottoRank.FIRST, LottoRank.SECOND, LottoRank.THIRD, LottoRank.NONE)).isEqualTo(lottos.lottosResult(wonLotto));
    }


}
