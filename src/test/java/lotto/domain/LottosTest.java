package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    private WonLotto wonLotto;

    @BeforeEach
    void setUp() {
        wonLotto = new WonLotto(new Lotto("1,2,3,4,5,6"), new LottoNumber(7));
    }

    @Test
    void testLottoPrize() {
        Lottos lottos = new Lottos();
        lottos.add(new Lotto("1,2,3,4,5,6"));
        lottos.add(new Lotto("1,2,3,4,5,7"));
        lottos.add(new Lotto("1,2,3,4,5,10"));
        lottos.add(new Lotto("7,8,9,10,11,12"));
        assertThat(Arrays.asList(LottoRank.FIRST, LottoRank.SECOND, LottoRank.THIRD, LottoRank.NONE)).isEqualTo(lottos.lottosResult(wonLotto));
    }

    @Test
    void testAppendLottos() {
        Lottos lottos = new Lottos();
        Lottos newLottos = new Lottos();
        lottos.add(new Lotto("1,2,3,4,5,6"));
        lottos.add(new Lotto("1,2,3,4,5,7"));
        lottos.add(new Lotto("1,2,3,4,5,10"));
        lottos.add(new Lotto("7,8,9,10,11,12"));
        newLottos.add(new Lotto("1,2,3,4,5,6"));
        newLottos.add(new Lotto("1,2,3,4,5,7"));
        newLottos.add(new Lotto("1,2,3,4,5,10"));
        newLottos.add(new Lotto("7,8,9,10,11,12"));
        lottos.appendLottos(newLottos);
        assertThat(Arrays.asList(LottoRank.FIRST, LottoRank.SECOND, LottoRank.THIRD,
                LottoRank.NONE, LottoRank.FIRST, LottoRank.SECOND, LottoRank.THIRD, LottoRank.NONE)).isEqualTo(lottos.lottosResult(wonLotto));
    }

}
