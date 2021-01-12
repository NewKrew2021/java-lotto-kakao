package domain;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AnswerTest {

    @Test
    void answerLottoTest() {
        Lotto lotto = new Lotto(new SelfLottoStrategy("1,2,3,4,5,6"));
        Answer answer = new Answer(new Lotto(new SelfLottoStrategy("1,2,3,4,5,6")), 7);
        assertThat(answer.getBonusNumber()).isEqualTo(LottoNumber.of(7));
        assertThat(answer.getAnswerLotto()).isEqualTo(lotto);
    }

    @Test
    void bonusNumberDuplicateTest() {
        assertThatThrownBy(() -> {new Answer(new Lotto(new SelfLottoStrategy("1,2,3,4,5,6")), 1);})
                .hasMessage("당첨 번호에 포함된 수가 있습니다.");
    }

}
