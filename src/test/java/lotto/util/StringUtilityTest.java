package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class StringUtilityTest {

    @Test
    @DisplayName("문자열 분할 테스트")
    void StringToIntegerListTest() {
        assertThat(StringUtility.StringToIntegerList("1,2,3,4,5")).containsExactlyInAnyOrderElementsOf(Arrays.asList(1, 2, 3, 4, 5));
        assertThat(StringUtility.StringToIntegerList("1, 2, 3, 4, 5")).containsExactlyInAnyOrderElementsOf(Arrays.asList(1, 2, 3, 4, 5));
    }

}
