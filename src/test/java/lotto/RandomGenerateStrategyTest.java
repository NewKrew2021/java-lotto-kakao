package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomGenerateStrategyTest {

    private final RandomGenerateStrategy randomGenerateStrategy = new RandomGenerateStrategy();

    @Test
    @DisplayName("랜덤으로 생성된 숫자들이 모두 범위 안에 있는지 확인한다.")
    void randomNumberRangeTest() {
        List<String> lottoNumbers = randomGenerateStrategy.generate();
        assertThat(lottoNumbers).allMatch((lottoNumber) -> (1 <= Integer.parseInt(lottoNumber) && Integer.parseInt(lottoNumber) <= 45));
    }

    @Test
    @DisplayName("랜덤으로 생성된 숫자들 사이에 중복이 없는지 확인한다.")
    void randomNumberDuplicateTest() {
        List<String> lottoNumbers = randomGenerateStrategy.generate();
        assertThat(lottoNumbers).doesNotHaveDuplicates();
    }
}
