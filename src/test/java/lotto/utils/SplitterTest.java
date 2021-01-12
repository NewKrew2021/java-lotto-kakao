package lotto.utils;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class SplitterTest {

    @Test
    public void splitStringToIntegerList() {
        List<Integer> numbers = Splitter.splitToNumberBy("4, 13, 17, 20, 25, 40", ",");
        assertThat(numbers).isEqualTo(Arrays.asList(4, 13, 17, 20, 25, 40));
    }
}
