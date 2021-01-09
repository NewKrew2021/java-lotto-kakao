package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberFactoryTest {

    @Test
    @DisplayName("같은 값을 갖는 로또 번호가 같은 객체인지 확인한다.")
    void getLottoNumberTest() {
        assertThat(LottoNumberFactory.getLottoNumber("1")).isSameAs(LottoNumberFactory.getLottoNumber("1"));
    }
}
