package domain;

import domain.Lotto;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoTest {

    @Test
    void lottoNumberTest() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lotto.equals(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)))).isTrue();
    }

    @Test
    void 로또_길이_6() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lotto.getLotto().size()).isEqualTo(6);
    }

    @Test
    void 로또_길이_6_미만() {
        assertThatExceptionOfType(IllegalStateException.class)
                .isThrownBy(() -> new Lotto(Arrays.asList(1, 2, 3, 4, 5)))
                .withMessageContaining("로또의 길이가 6이 아닙니다.");
    }

    @Test
    void 로또_길이_6_이상() {
        assertThatExceptionOfType(IllegalStateException.class)
                .isThrownBy(() -> new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6, 7)))
                .withMessageContaining("로또의 길이가 6이 아닙니다.");
    }
}
