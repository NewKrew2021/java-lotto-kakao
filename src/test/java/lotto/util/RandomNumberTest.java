package lotto.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberTest {

    @Test
    void duplicationTest() {
        assertThat(RandomNumberGenerator.getNumbers()).doesNotHaveDuplicates();
    }
}
