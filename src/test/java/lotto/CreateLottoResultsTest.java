package lotto;

import lotto.domain.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateLottoResultsTest {
    @Test
    void createLottoResultsTest() {
        LottoTickets lottoTickets = new LottoTickets(CreateTicket.createTotalTicket(14000, Arrays.asList("1,2,3,4,5,6")));
        WinningNumber winningNumber = new WinningNumber("1, 2, 3, 4, 5, 6", 7);

        Map<LottoRank, Integer> lottoResults = new HashMap<LottoRank, Integer>();
        lottoTickets.getLottoTickets().stream()
                .forEach(lottoTicket -> {
                    LottoRank rank = LottoRank.getRank(lottoTicket.matchCount(winningNumber),
                            winningNumber.bonusNumberContain(lottoTicket));
                    lottoResults.putIfAbsent(rank, 0);
                    lottoResults.put(rank, lottoResults.get(rank)+1);
                });

        assertThat(CreateLottoResults.createLottoResults(lottoTickets.getLottoTickets(), winningNumber)).
                isEqualTo(new LottoResults(lottoResults));
    }
}
