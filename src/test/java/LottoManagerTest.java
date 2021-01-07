import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoManagerTest {

    private LottoManager lottoManager = new LottoManager();

    @Test
    void lottoResultTest() {
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,7));
        AnswerLotto answerLotto = new AnswerLotto(Arrays.asList(1,2,3,4,5,6),7);

        assertThat(lottoManager.checkResult(lotto, answerLotto)).isEqualTo(LottoStatus.SECOND);
    }
}
