package utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class StringUtilsTest {

    @Test
    void StringSplitTest() {
        String inputText = "1 , 2, 3, 4, 5, 6";

        List<String> results = StringUtils.splitText(inputText);

        assertThat(results).containsExactly("1", "2", "3", "4", "5", "6");
    }

    @ParameterizedTest
    @NullAndEmptySource
    void StringSplitEmptyExceptionTest(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(
                () -> {
                    StringUtils.splitText(input);
                }
        ).withMessageMatching("문자열을 입력해주세요.");
    }
}
