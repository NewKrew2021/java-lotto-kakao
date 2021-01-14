package lotto.domain;

import lotto.service.LottoGeneratorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    private WonLotto wonLotto;
    private LottoGeneratorService lottoGeneratorService;

    @BeforeEach
    void setUp() {
        lottoGeneratorService = new LottoGeneratorService();
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

}
