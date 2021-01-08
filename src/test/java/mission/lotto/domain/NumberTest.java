package mission.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumberTest {

    @Test
    @DisplayName("로또번호_정상생성_테스트")
    public void 로또번호_정상생성_테스트() {
        Number lottoNumber = new Number(4);
        assertThat(lottoNumber.toString()).isEqualTo("4");

        Number lottoNumber2 = new Number(45);
        assertThat(lottoNumber2.toString()).isEqualTo("45");

        Number lottoNumber3 = new Number(1);
        assertThat(lottoNumber3.toString()).isEqualTo("1");
    }

    @Test
    @DisplayName("로또번호제한_예외발생_테스트")
    public void 로또번호제한_예외발생_테스트() {
        assertThatThrownBy(() -> new Number(46))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new Number(0))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new Number(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
