package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {

    @Test
    @DisplayName("LottoNumber 클래스에 올바른 입력이 주어졌을 때 정상적으로 생성되는지 확인한다.")
    void createTest() {
        LottoNumber lottoNumber = LottoNumber.valueOf("3");
        assertThat(lottoNumber).isEqualTo(LottoNumber.valueOf("3"));
        assertThat(lottoNumber).isSameAs(LottoNumber.valueOf("3"));
    }

    @Test
    @DisplayName("LottoNumber 클래스에 정수가 아닌 문자열이 주어졌을 때 예외가 발생한다.")
    void integerTest() {
        assertThatThrownBy(() -> {
            LottoNumber lottoNumber = LottoNumber.valueOf("a");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("LottoNumber 클래스에 범위를 벗어나는 정수가 주어졌을 때 예외가 발생한다.")
    @CsvSource({"0", "46"})
    void rangeTest(String lottoNumberString) {
        assertThatThrownBy(() -> {
            LottoNumber lottoNumber = LottoNumber.valueOf(lottoNumberString);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
