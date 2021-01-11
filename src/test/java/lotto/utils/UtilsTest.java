package lotto.utils;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UtilsTest {

    @Test
    public void extractIntFromTest() {
        List<Integer> testIntegers = Arrays.asList(1, 2, 30, 200, 10, 0);
        String testString = "1, 2,  30, 200 , 10  , 0";

        assertThat(Utils.extractIntFrom(testString, ",")).isEqualTo(testIntegers);
    }
}
