package domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {

    @Test
    void createTest() {
        LottoNumber lottoNumber = LottoNumber.of(5);
        assertThat(lottoNumber == LottoNumber.of(5)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {-1,0,46,47})
    void lottoNumberRangeTest(int number) {
        assertThatThrownBy(()->{
            LottoNumber.of(number);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageMatching("[0-9]* ~ [0-9]* 사이의 숫자를 입력해주세요.");
    }
}
