package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import domain.exceptions.InvalidLottoNumberException;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class LottoWinningNumberTest {

  @Test
  void create() {
    LottoTicket lottoWinningTicket = LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 6));
    LottoNumber bonusNumber = LottoNumber.of(7);
    LottoWinningNumber lottoWinningNumber = new LottoWinningNumber(lottoWinningTicket, bonusNumber);
    assertThat(lottoWinningNumber)
        .isEqualTo(new LottoWinningNumber(lottoWinningTicket, bonusNumber));
  }

  @Test
  void isDuplicate() {
    LottoTicket lottoWinningTicket = LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 6));
    LottoNumber bonusNumber = LottoNumber.of(6);
    assertThatExceptionOfType(InvalidLottoNumberException.class)
        .isThrownBy(() -> new LottoWinningNumber(lottoWinningTicket, bonusNumber));
  }

}