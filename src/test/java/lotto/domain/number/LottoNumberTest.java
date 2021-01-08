package lotto.domain.number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumberTest {
    @DisplayName("1~45 범위의 숫자가 주어졌을 때, 숫자로 로또 번호를 만들면, 로또 번호가 생성된다")
    @ParameterizedTest
    @ValueSource(ints = {1, 45})
    void create(int number) {
        // when
        LottoNumber lottoNumber = LottoNumber.valueOf(number);

        // then
        assertThat(lottoNumber).isEqualTo(LottoNumber.valueOf(number));
    }

    @DisplayName("1~45 범위를 벗어나는 숫자가 주어졌을 때, 숫자로 로또 번호를 만들면, 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void invalid(int number) {
        // then
        assertThatIllegalArgumentException()
                // when
                .isThrownBy(() -> LottoNumber.valueOf(number))
                .withMessage("1~45 범위의 숫자만 허용됩니다");
    }
}
