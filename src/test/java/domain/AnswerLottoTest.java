package domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class AnswerLottoTest {
    @Test
    void answerLottoTest() {
        AnswerLotto answerLotto = new AnswerLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), new LottoNumber(7));

        assertThat(answerLotto.equals(new AnswerLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), new LottoNumber(7)))).isTrue();
    }

    @Test
    void 길이_6_미만() {
        assertThatExceptionOfType(InvalidLottoException.class)
                .isThrownBy(() -> new AnswerLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5)), new LottoNumber(7)))
                .withMessageContaining("로또의 길이가 6이 아닙니다.");
    }

    @Test
    void 길이_6_초과() {
        assertThatExceptionOfType(InvalidLottoException.class)
                .isThrownBy(() -> new AnswerLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6, 7)), new LottoNumber(7)))
                .withMessageContaining("로또의 길이가 6이 아닙니다.");
    }

    @Test
    void 로또_보너스_중복() {
        assertThatExceptionOfType(InvalidLottoException.class)
                .isThrownBy(() -> new AnswerLotto(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), new LottoNumber(6)))
                .withMessageContaining("로또번호에 보너스가 포함되어있습니다.");
    }

}

