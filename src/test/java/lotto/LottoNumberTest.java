package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoNumberTest {

    @Test
    void lottoNumberTest() {

        assertThat(LottoNumber.of(45)).isEqualTo(LottoNumber.of(45));
    }

}
