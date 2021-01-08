package domain;

import domain.AnswerLotto;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class AnswerLottoTest {
    @Test
    void answerLottoTest() {
        AnswerLotto answerLotto = new AnswerLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        assertThat(answerLotto.equals(new AnswerLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 7))).isTrue();
    }

    @Test
    void 길이_6() {
        AnswerLotto answerLotto = new AnswerLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        assertThat(answerLotto.getAnswerLotto().size()).isEqualTo(6);
    }

    @Test
    void 길이_6_미만() {
        assertThatExceptionOfType(IllegalStateException.class)
                .isThrownBy(() -> new AnswerLotto(Arrays.asList(1, 2, 3, 4, 5), 7))
                .withMessageContaining("로또 길이가 6이 아닙니다.");
    }

    @Test
    void 길이_6_초과() {
        assertThatExceptionOfType(IllegalStateException.class)
                .isThrownBy(() -> new AnswerLotto(Arrays.asList(1, 2, 3, 4, 5, 6, 7), 7))
                .withMessageContaining("로또 길이가 6이 아닙니다.");
    }

    @Test
    void 로또_보너스_중복() {
        assertThatExceptionOfType(IllegalStateException.class)
                .isThrownBy(() -> new AnswerLotto(Arrays.asList(1,2,3,4,5,6),6))
                .withMessageContaining("로번호에 보너스가 포함되어있습니다.");
    }

}
