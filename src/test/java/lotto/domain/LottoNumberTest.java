package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LottoNumberTest {

    @Test
    void lottoNumberTest(){
        LottoNumber lottoNumber = LottoNumber.makeNumber(3);
        assertTrue(lottoNumber.equals(3));
        assertTrue(lottoNumber.equals(LottoNumber.makeNumber(3)));
    }

    @Test
    void lottoNumberFromTextTest(){
        LottoNumber lottoNumber = LottoNumber.makeNumberFromText("31");
        assertTrue(lottoNumber.equals(31));
    }

    @Test
    void outOfBoundNumberTest(){
        assertThatThrownBy(()->{
            LottoNumber.makeNumber(LottoNumber.LOTTO_MIN_NUMBER-1);
        }).isInstanceOf(RuntimeException.class);

        assertThatThrownBy(()->{
            LottoNumber.makeNumber(LottoNumber.LOTTO_MAX_NUMBER+1);
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    void blankNumberTest(){
        assertThatThrownBy(() -> {
            LottoNumber.makeNumberFromText("");
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    void notNumberTest(){
        assertThatThrownBy(() -> {
            LottoNumber.makeNumberFromText("ab");
        }).isInstanceOf(RuntimeException.class);
    }
}
