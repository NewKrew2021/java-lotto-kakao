package lotto.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberTest {
    final int NUM_OF_REPEAT = 100;

    RandomNumberGenerator randomNumberGenerator;
    @BeforeEach
    void setUp(){
        randomNumberGenerator = new RandomNumberGenerator();
    }

    @Test
    void duplicationTest(){
        for (int i = 0; i < NUM_OF_REPEAT; i++) {
            assertThat(randomNumberGenerator.getNumbers()).doesNotHaveDuplicates();
        }
    }
}
