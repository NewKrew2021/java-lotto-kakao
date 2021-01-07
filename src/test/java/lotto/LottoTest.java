package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @Test
    void createTest() {
        Lotto lotto = new Lotto("1, 2, 3, 4, 5, 6");
        assertThat(lotto).isEqualTo(new Lotto("1, 2, 3, 4, 5, 6"));
    }

    @Test
    void lottoRangeTest() {
        assertThatThrownBy(() -> {
            Lotto lotto = new Lotto("0, 1, 2, 3, 4, 5");
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            Lotto lotto = new Lotto("1, 2, 3, 4, 5, 46");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void lottoNotIntegerTest() {
        assertThatThrownBy(() -> {
            Lotto lotto = new Lotto("1, a, 2, 3, 4, 5");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void lottoDuplicateTest() {
        assertThatThrownBy(() -> {
            Lotto lotto = new Lotto("1, 1, 2, 3, 4, 5");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void lottoCountTest() {
        assertThatThrownBy(() -> {
            Lotto lotto = new Lotto("1, 2, 3, 4, 5, 6, 7");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void lottoDuplicateCountTest() {
        assertThatThrownBy(() -> {
            Lotto lotto = new Lotto("1, 1, 2, 3, 4, 5, 6");
        }).isInstanceOf(IllegalArgumentException.class);
    }


}
