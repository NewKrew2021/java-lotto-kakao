package domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

import domain.exceptions.InvalidLottoNumberException;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class LottoTicketTest {

  @Test
  public void create() {
    LottoTicket lottoTicket = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 45));
    assertThat(lottoTicket).isEqualTo(new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 45)));
  }

  @Test
  public void isInValidLength() {
    assertThatExceptionOfType(InvalidLottoNumberException.class)
        .isThrownBy(() -> new LottoTicket(Arrays.asList(1, 2, 3, 4, 5)));
    assertThatExceptionOfType(InvalidLottoNumberException.class)
        .isThrownBy(() -> new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6, 7)));
    assertThatExceptionOfType(InvalidLottoNumberException.class)
        .isThrownBy(() -> new LottoTicket(Arrays.asList()));
    assertThatExceptionOfType(InvalidLottoNumberException.class)
        .isThrownBy(() -> new LottoTicket(null));
  }

  @Test
  void isDuplicateNumber() {
    assertThatExceptionOfType(InvalidLottoNumberException.class)
        .isThrownBy(() -> new LottoTicket(Arrays.asList(1, 1, 2, 3, 4, 5)));
  }

  @Test
  void isInvalidNumber() {
    assertThatExceptionOfType(InvalidLottoNumberException.class)
        .isThrownBy(() -> new LottoTicket(Arrays.asList(0, 2, 3, 4, 5, 6)));
    assertThatExceptionOfType(InvalidLottoNumberException.class)
        .isThrownBy(() -> new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 46)));
  }

  @Test
  void matchedCount() {
    LottoTicket lottoTicket = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 45));
    LottoTicket winningLottoTicket = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 45));
    assertThat(lottoTicket.getMatchedCount(winningLottoTicket)).isEqualTo(6);
  }
}
