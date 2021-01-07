package lotto.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberTest {
    RandomNumberGenerator randomNumberGenerator;
    @BeforeEach
    void setUp(){
        randomNumberGenerator = new RandomNumberGenerator();
    }

    @Test
    void rangeTest(){
        randomNumberGenerator.getNumbers().stream().forEach(num -> assertThat(num).isBetween(1,45));
    }

    @Test
    void duplicationTest(){
        assertThat(randomNumberGenerator.getNumbers()).doesNotHaveDuplicates();
    }
}
