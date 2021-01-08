package lotto.domain;

import lotto.exception.OutOfRangeException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoNumberTest {

    @Test
    void lottoNumberTest() {
        assertThat(LottoNumber.of(45)).isEqualTo(LottoNumber.of(45));
    }

    @Test
    void lottoBoundaryTest() {
        assertThatExceptionOfType(OutOfRangeException.class).isThrownBy(() -> {
            LottoNumber.of(46);
        }).withMessageMatching("잘못된 숫자를 입력하셨습니다.");
    }

    @Test
    void lottoBoundaryTest2() {
        assertThatExceptionOfType(OutOfRangeException.class).isThrownBy(() -> {
            LottoNumber.of(0);
        }).withMessageMatching("잘못된 숫자를 입력하셨습니다.");
    }
}
