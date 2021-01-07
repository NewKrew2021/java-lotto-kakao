package domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AnswerTest {
    @Test
    void answerLottoTest() {
        Answer answer = new Answer("1,2,3,4,5,6",7);
        assertThat(answer.getBonusNumber()).isEqualTo(7);
        assertThat(answer.getAnswerNumbers()).containsExactly(1,2,3,4,5,6);
    }

    @Test
    void StringSplitInvalidStringExceptionTest() {
        assertThatThrownBy(()->{
            new Answer("abcdf,egsdd,gwwef", 6);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("숫자가 아닙니다.");
    }

    @Test
    void StringToIntegerMappingTest() {
        Answer answer = new Answer("1,2,3,4,5", 6);
        assertThat(answer.getAnswerNumbers()).containsExactly(1,2,3,4,5);
    }
}
