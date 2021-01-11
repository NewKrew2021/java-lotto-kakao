package mission.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumbersTest {

    @Test
    @DisplayName("로또 번호 집합 생성 테스트 : 순서가 달라도 로또 생성에는 상관없다")
    public void create() {
        LottoNumbers lottoNumbers1 = new LottoNumbers(Arrays.asList(3, 2, 1, 4, 5, 6));
        LottoNumbers lottoNumbers2 = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 6, 5));
        assertThat(lottoNumbers1).isEqualTo(lottoNumbers2);
    }

    @Test
    @DisplayName("로또 번호 집합 생성 예외 테스트 : 6자리가 아니면 예외 발생")
    public void 길이에러ThrowTest() {
        assertThatThrownBy(() ->
                new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6, 7))
        ).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() ->
                new LottoNumbers(Arrays.asList(1, 2, 7))
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("특정 번호가 포함되는지 확인하는 테스트")
    public void containNumberTest() {
        LottoNumbers lottoNumbers1 = new LottoNumbers(Arrays.asList(3, 2, 1, 4, 5, 6));

        assertThat(lottoNumbers1.isContainLottoNumber(new Number(1))).isEqualTo(true);
        assertThat(lottoNumbers1.isContainLottoNumber(new Number(7))).isEqualTo(false);
    }
}
