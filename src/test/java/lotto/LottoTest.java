package lotto;

import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @Test
    void lottoRangeTest() {
        assertThatThrownBy(() -> {
            Lotto lotto = new Lotto("0, 1, 2, 3, 4, 5");
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            Lotto lotto = new Lotto("1, 2, 3, 4, 5, 46");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
