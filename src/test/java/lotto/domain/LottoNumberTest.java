package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoNumberTest {

    @Test
    public void create() {
        LottoNumber lottoNumber = new LottoNumber(7);
        assertThat(lottoNumber).isEqualTo(new LottoNumber(7));
    }

    @Test
    public void validateNumberRangeUpper() {
        assertThatThrownBy(() -> {
            new LottoNumber(46);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void validateNumberRangeLower() {
        assertThatThrownBy(() -> {
            new LottoNumber(0);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
