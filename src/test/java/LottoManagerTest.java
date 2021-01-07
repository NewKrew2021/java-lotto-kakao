import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoManagerTest {

    private LottoManager lottoManager;

    @Test
    void lottoPrizeResultTest() {
        Lottos lottos = new Lottos(Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)),
                new Lotto(Arrays.asList(3, 4, 5, 6, 7, 8))
        ));
        AnswerLotto answerLotto = new AnswerLotto(Arrays.asList(1,2,3,4,5,6),7);
        lottoManager = new LottoManager(lottos, answerLotto);
        assertThat(lottoManager.checkResult().keySet()).containsExactly(LottoStatus.FIRST,
                LottoStatus.SECOND, LottoStatus.FOURTH);
    }

    @Test
    void lottoPrizeCountResultTest() {
        Lottos lottos = new Lottos(Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(3, 4, 5, 6, 7, 8))
        ));
        AnswerLotto answerLotto = new AnswerLotto(Arrays.asList(1,2,3,4,5,6),7);
        lottoManager = new LottoManager(lottos, answerLotto);
        assertThat(lottoManager.checkResult().get(LottoStatus.FIRST)).isEqualTo(2);
        assertThat(lottoManager.checkResult().get(LottoStatus.FOURTH)).isEqualTo(1);
    }



}
