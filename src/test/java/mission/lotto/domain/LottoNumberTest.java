package mission.lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {

    @Test
    public void 로또번호_정상생성_테스트() {
        Number lottoNumber = new Number(4);
        assertThat(lottoNumber).isEqualTo(new Number(4));
    }

    @Test
    public void 로또번호제한_예외발생_테스트() {
        assertThatThrownBy(() -> new Number(46))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
