package domain;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.assertj.core.api.Assertions.assertThat;

public class AnswerTest {

    @Test
    void answerLottoTest() {
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        Answer answer = new Answer(new Lotto(Arrays.asList(1,2,3,4,5,6)), 7);
        assertThat(answer.getBonusNumber()).isEqualTo(new LottoNumber(7));
        assertThat(answer.getAnswerLotto()).isEqualTo(lotto);
    }

}
