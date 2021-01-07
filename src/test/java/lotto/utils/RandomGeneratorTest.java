package lotto.utils;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomGeneratorTest {

    @Test
    public void testNonDuplicatedInt() {
        Set<Integer> integers = RandomGenerator.nonDuplicatedInt(1, 4, 4);
        assertThat(integers).contains(1,2,3,4);
    }
}
