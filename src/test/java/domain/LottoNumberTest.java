package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoNumberTest {
    @Test
    void 범위_바깥() {
        assertThatExceptionOfType(LottoException.class)
                .isThrownBy(() -> new LottoNumber(46))
                .withMessageContaining("로또 범위 밖입니다.");
        assertThatExceptionOfType(LottoException.class)
                .isThrownBy(() -> new LottoNumber(0))
                .withMessageContaining("로또 범위 밖입니다.");
    }

    @Test
    void 같은_숫자() {
        LottoNumber lottoNumber = new LottoNumber(1);

        assertThat(lottoNumber.equals(new LottoNumber(1)))
                .isTrue();
    }
}

