package lotto.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberTest {
    final int NUM_OF_REPEAT = 100;

    @Test
    void duplicationTest(){
        for (int i = 0; i < NUM_OF_REPEAT; i++) {
            assertThat(RandomNumberGenerator.generate()).doesNotHaveDuplicates();
        }
    }
}
