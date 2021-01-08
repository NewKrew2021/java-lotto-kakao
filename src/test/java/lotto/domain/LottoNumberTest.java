package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class LottoNumberTest {

    @Test
    void create() {
        assertThat(LottoNumber.of(45)).isEqualTo(LottoNumber.of(45));
    }

    @Test
    void create_outOfRange() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            LottoNumber.of(48);
        }).withMessageMatching("로또 번호는 1~45 사이의 정수여야 합니다.");
    }
}
