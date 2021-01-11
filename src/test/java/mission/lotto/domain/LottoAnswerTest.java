package mission.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoAnswerTest {

    @Test
    @DisplayName("LottoAnswer 생성 예외 테스트 ")
    public void 정답계산() {
        assertThatThrownBy(() -> new LottoAnswer(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Number(5)
        )).isInstanceOf(IllegalArgumentException.class);
    }

}


