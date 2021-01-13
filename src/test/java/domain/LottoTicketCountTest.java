package domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

import domain.exceptions.InvalidLottoCountException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LottoTicketCountTest {

  Amount amount;
  int manualCount;

  @BeforeEach
  void setUp() {
    amount = new Amount(5000);
  }

  @Test
  void create() {
    manualCount = 3;
    LottoTicketCount lottoTicketCount = new LottoTicketCount(amount, manualCount);
    assertThat(lottoTicketCount).isEqualTo(new LottoTicketCount(amount, manualCount));
    assertThat(lottoTicketCount.getAutoCount()).isEqualTo(2);
  }

  @Test
  void invalid() {
    manualCount = 6;
    assertThatExceptionOfType(InvalidLottoCountException.class)
        .isThrownBy(() -> new LottoTicketCount(amount, manualCount));
  }
}
