package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    @Test
    void getSize() {
        Lottos lottos = Lottos.getInstance(3);
        assertThat(lottos.size()).isEqualTo(3);
    }

}
