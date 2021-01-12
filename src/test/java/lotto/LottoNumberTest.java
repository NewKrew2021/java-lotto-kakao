package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LottoNumberTest {
    @Test
    public void createNumber() {
        assertThatThrownBy(() -> {
            LottoNumber lottoNumber = LottoNumber.of(0);
        });
        assertThatThrownBy(() -> {
            LottoNumber lottoNumber = LottoNumber.of(46);
        });
        LottoNumber lottoNumber = LottoNumber.of(1);
        LottoNumber lottoNumber2 = LottoNumber.of(45);
    }

    @Test
    void sameInstance() {
        assertTrue(LottoNumber.of(1) == LottoNumber.of(1));
        assertFalse(LottoNumber.of(1) == LottoNumber.of(2));
    }

}
