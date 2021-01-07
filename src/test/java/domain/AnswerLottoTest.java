package domain;

import domain.AnswerLotto;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class AnswerLottoTest {
    @Test
    void answerLottoTest() {
        AnswerLotto answerLotto = new AnswerLotto(Arrays.asList(1,2,3,4,5,6),7);
        assertThat(answerLotto.equals(new AnswerLotto(Arrays.asList(1,2,3,4,5,6),7))).isTrue();
    }

}
