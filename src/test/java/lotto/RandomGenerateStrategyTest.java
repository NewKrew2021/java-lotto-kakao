package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomGenerateStrategyTest {

    private final RandomGenerateStrategy randomGenerateStrategy = new RandomGenerateStrategy();

    @Test
    void randomNumberRangeTest() {
        List<String> lottoNumbers = randomGenerateStrategy.generate();
        assertThat(lottoNumbers).allMatch((lottoNumber) -> (1 <= Integer.parseInt(lottoNumber) && Integer.parseInt(lottoNumber) <= 45));
    }

    @Test
    void randomNumberDuplicateTest() {
        List<String> lottoNumbers = randomGenerateStrategy.generate();
        assertThat(lottoNumbers).doesNotHaveDuplicates();
    }
}
