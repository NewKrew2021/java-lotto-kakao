package lotto;

import lotto.domain.*;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateLottoResultsTest {
    @Test
    void createLottoResultsTest() {
        LottoTickets lottoTickets = new LottoTickets(CreateTicket.createAutoTicket(14000));
        WinningNumber winningNumber = new WinningNumber("1, 2, 3, 4, 5, 6", 7);

        LottoResults lottoResults = new LottoResults(CreateLottoResults.createLottoResults(lottoTickets.getLottoTickets(), winningNumber));

        assertThat(lottoResults).
                isEqualTo(new LottoResults(CreateLottoResults.createLottoResults(lottoTickets.getLottoTickets(), winningNumber)));
    }
}
