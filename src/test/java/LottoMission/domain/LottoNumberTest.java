package LottoMission.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class LottoNumberTest {

    @Test
    public void 로또번호_정상생성_테스트() {
        LottoNumber lottoNumber = new LottoNumber(4);
        assertThat(lottoNumber).isEqualTo(new LottoNumber(4));
    }

    @Test
    public void 로또번호제한_예외발생_테스트() {
        assertThatThrownBy(() -> new LottoNumber(46))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
