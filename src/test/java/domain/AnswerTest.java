package domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class AnswerTest {
    @Test
    void answerLottoTest() {
        Answer answer = new Answer(Arrays.asList(1,2,3,4,5,6),7);
        assertThat(answer.getBonusNumber()).isEqualTo(7);
        assertThat(answer.getAnswerNumbers()).containsExactly(1,2,3,4,5,6);
    }

}
