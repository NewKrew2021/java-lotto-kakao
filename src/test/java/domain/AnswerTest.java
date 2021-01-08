package domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AnswerTest {
    @Test
    void answerLottoTest() {
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        Answer answer = new Answer(new Lotto(Arrays.asList(1,2,3,4,5,6)), 7);
        assertThat(answer.getBonusNumber()).isEqualTo(new LottoNumber(7));
        assertThat(answer.getAnswerLotto()).isEqualTo(lotto);
    }

    @Test
    void StringSplitInvalidStringExceptionTest() {
        assertThatThrownBy(()->{
            new Answer(new Lotto("abcdf,egsdd,gwwef"), 6);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("숫자가 아닌 입력이 포함되어 있습니다.");
    }

}
