package lotto.domain;

import lotto.exception.OutOfRangeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoNumberTest {

    @Test
    @DisplayName("로또번호 정상 생성 테스트")

    void lottoNumberTest() {
        assertThat(LottoNumber.of(45)).isEqualTo(LottoNumber.of(45));
    }

    @Test
    @DisplayName("로또번호 예외처리 테스트")
    void lottoBoundaryTest() {
        assertThatExceptionOfType(OutOfRangeException.class).isThrownBy(() -> {
            LottoNumber.of(46);
        }).withMessageMatching("잘못된 숫자를 입력하셨습니다.");
    }

    @Test
    @DisplayName("로또번호 예외처리 테스트")
    void lottoBoundaryTest2() {
        assertThatExceptionOfType(OutOfRangeException.class).isThrownBy(() -> {
            LottoNumber.of(0);
        }).withMessageMatching("잘못된 숫자를 입력하셨습니다.");
    }
}
