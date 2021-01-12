package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class NumberGeneratorTest {

    @Test
    public void generateNumber() {
        LottoNumbers generatedNumbers = NumberGenerator.generateBuyNumbers(() ->
                new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6))
        );
        assertThat(generatedNumbers).isEqualTo(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }
}
