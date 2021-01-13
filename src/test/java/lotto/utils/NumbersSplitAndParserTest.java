package lotto.utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumbersSplitAndParserTest {
    @Test
    void testSplitAndParser() {
        assertThat(NumbersSplitAndParser.parseToIntegers("1, 0, -1, 46"))
                .containsExactlyInAnyOrder(1, 0, -1, 46);
    }

    @Test
    void OneOrMoreOfThemIsNotNumber() {
        assertThatThrownBy(() -> NumbersSplitAndParser.parseToIntegers("1, a"))
                .isInstanceOf(NumberFormatException.class);
    }
}
