package mission.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TryNumberTest {

    @Test
    @DisplayName("TryNumber 정상 생성 테스트")
    public void tryNumberTest() {
        TryNumber tryNumber = new TryNumber(1);
        assertThat(tryNumber.hasNext()).isEqualTo(true);

        TryNumber tryNumber2 = new TryNumber(0);
        assertThat(tryNumber2.hasNext()).isEqualTo(false);
    }

    @Test
    @DisplayName("TryNumber 예외 테스트(음수가 주어졌을 때) ")
    public void tryNumberTest2() {
        assertThatThrownBy(() -> new TryNumber(-5))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("시도 횟수를 잘 소모하는지 테스트")
    public void useTryNumberTest() {
        TryNumber tryNumber = new TryNumber(2);
        tryNumber.useTryNumberCount();
        assertThat(tryNumber.hasNext()).isEqualTo(true);

        tryNumber.useTryNumberCount();
        assertThat(tryNumber.hasNext()).isEqualTo(false);
    }

}
