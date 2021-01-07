package LottoMission.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumbersTest {

    @Test
    public void create() {
        LottoNumbers lottoNumbers1 = new LottoNumbers(Arrays.asList(3, 2, 1, 4, 5, 6));
        LottoNumbers lottoNumbers2 = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 6, 5));
        assertThat(lottoNumbers1).isEqualTo(lottoNumbers2);
    }

    @Test
    public void 길이에러ThrowTest() {
        assertThatThrownBy(() ->
                new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6, 7))
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
