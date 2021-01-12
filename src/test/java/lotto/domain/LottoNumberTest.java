package lotto.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.*;

public class LottoNumberTest {

    @Test
    void lottoNoTest() {

        assertThatThrownBy(()->{
            new LottoNumber(0);
        }).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()->{
            new LottoNumber(46);
        }).isInstanceOf(IllegalArgumentException.class);

        LottoNumber lottoNumber1 = new LottoNumber(1);
        LottoNumber lottoNumber2 = new LottoNumber(45);

    }

    @Test
    void lottoEqualTest(){
        LottoNumber lotto1 = new LottoNumber(1);
        LottoNumber lotto2 = new LottoNumber(2);
        assertThat(lotto1).isNotEqualTo(lotto2);

        LottoNumber lotto3_1 = new LottoNumber(3);
        LottoNumber lotto3_2 = new LottoNumber(3);
        assertThat(lotto3_2).isEqualTo(lotto3_1);
    }
}
