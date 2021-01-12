package lotto;

import lotto.domain.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateLottoResultsTest {
    @Test
    void createLottoResultsTest() {
        LottoTickets lottoTickets = new LottoTickets(CreateTicket.createTotalTicket(14000, Arrays.asList("1,2,3,4,5,6")));
        WinningNumber winningNumber = new WinningNumber("1, 2, 3, 4, 5, 6", 7);

        LottoResults lottoResults = new LottoResults(CreateLottoResults.createLottoResults(lottoTickets.getLottoTickets(), winningNumber));

        assertThat(lottoResults).
                isEqualTo(new LottoResults(CreateLottoResults.createLottoResults(lottoTickets.getLottoTickets(), winningNumber)));
    }
}
