package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LottoNumberTest {
    @Test
    public void createNumber() {
        assertThatThrownBy(() -> {
            LottoNumber lottoNumber = LottoNumber.getInstance(0);
        });
        assertThatThrownBy(() -> {
            LottoNumber lottoNumber = LottoNumber.getInstance(46);
        });
        LottoNumber lottoNumber = LottoNumber.getInstance(1);
        LottoNumber lottoNumber2 = LottoNumber.getInstance(45);
    }

    @Test
    void sameInstance() {
        LottoNumber lottoNumber = LottoNumber.getInstance(1);
        LottoNumber lottoNumber2 = LottoNumber.getInstance(1);
        assertTrue(lottoNumber.equals(lottoNumber2));
        assertFalse(LottoNumber.getInstance(1).equals(LottoNumber.getInstance(2)));
    }

}
