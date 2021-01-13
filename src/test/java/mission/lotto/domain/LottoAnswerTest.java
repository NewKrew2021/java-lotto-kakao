package mission.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoAnswerTest {

    @Test
    @DisplayName("LottoAnswer 생성 예외 테스트 ")
    public void answerTest() {
        assertThatThrownBy(() -> new LottoAnswer(Arrays.asList(1, 2, 3, 4, 5, 6), 5))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Getter로 받아온 Set이 불변객체인지 확인하는 테스트")
    public void immutableTest() {
        assertThatThrownBy(() -> {
            LottoAnswer lottoAnswer = new LottoAnswer(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
            Set<Number> answerNumbers = lottoAnswer.getAnswerNumbers();
            answerNumbers.add(Number.of(45));
        }).isInstanceOf(UnsupportedOperationException.class);
    }
}


