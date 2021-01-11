package domain;

import domain.exceptions.InvalidLottoNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class LottoNumberTest {

    @DisplayName("LottoNumber 객체 생성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 45})
    void create(int number) {
        LottoNumber lottoNumber = new LottoNumber(number);
        assertThat(lottoNumber).isEqualTo(new LottoNumber(number));
    }

    @DisplayName("로또 번호가 1 미만이거나 45를 초과하면 InvalidLottoNumberException을 던진다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void invalidNumber(int number) {
        assertThatExceptionOfType(InvalidLottoNumberException.class)
                .isThrownBy(() -> new LottoNumber(number));
    }
}
