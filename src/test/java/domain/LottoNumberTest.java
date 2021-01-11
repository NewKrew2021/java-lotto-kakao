package domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

import domain.exceptions.InvalidLottoNumberException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {

  @ParameterizedTest
  @ValueSource(ints = {1, 45})
  void create(int number) {
    LottoNumber lottoNumber = new LottoNumber(number);
    assertThat(lottoNumber).isEqualTo(new LottoNumber(number));
  }

  @ParameterizedTest
  @ValueSource(ints = {0, 46})
  void invalidNumber(int number) {
    assertThatExceptionOfType(InvalidLottoNumberException.class)
        .isThrownBy(() -> new LottoNumber(number));
  }

  @Test
  void nullTest() {
    assertThatExceptionOfType(InvalidLottoNumberException.class)
        .isThrownBy(() -> new LottoNumber(null));
  }
}
