package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class NumberGeneratorTest {

    @Test
    public void generateNumber() {
        UserBuyNumbers generatedNumbers = NumberGenerator.generateBuyNumbers(() ->
                new UserBuyNumbers(Arrays.asList(1,2,3,4,5,6))
        );
        assertThat(generatedNumbers).isEqualTo(new UserBuyNumbers(Arrays.asList(1,2,3,4,5,6)));
    }
}
