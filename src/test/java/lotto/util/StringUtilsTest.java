package lotto.util;

import lotto.domain.LottoNumber;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringUtilsTest {
    @Test
    void nullNumberTest(){
        assertThatThrownBy(()->{
            LottoNumber.makeNumberFromText(null);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void blankNumberTest(){
        assertThatThrownBy(() -> {
            LottoNumber.makeNumberFromText("");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void notNumberTest(){
        assertThatThrownBy(() -> {
            LottoNumber.makeNumberFromText("ab");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
