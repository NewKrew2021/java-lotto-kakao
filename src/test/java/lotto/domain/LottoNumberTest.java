package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoNumberTest {

    @Test
    @DisplayName("1~45범위 밖에서 에러 발생하는지 확인")
    public void testAmountRange(){
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(()->new LottoNumber(0));
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(()->new LottoNumber(46));

    }

}
