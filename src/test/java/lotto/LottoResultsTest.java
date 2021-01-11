package lotto;

import lotto.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class LottoResultsTest {
    private CreateTicket createTicket;
    private WinningNumber winningNumber;

    @BeforeEach
    void setInit(){
        createTicket = new CreateTicket(14000);
        winningNumber = new WinningNumber("1, 2, 3, 4, 5, 6", 7);
    }

    @Test
    void createLottoResultsTest() {
        LottoResults lottoResults = LottoResults.createLottoResults(createTicket.allocateTicket(), winningNumber);
        assertThat(lottoResults).
                isEqualTo(LottoResults.createLottoResults(createTicket.allocateTicket(), winningNumber));
    }

    @Test
    void getLottoResultsTest(){
        Map<LottoRank, Integer> results = new HashMap<LottoRank, Integer>() {{
            for (LottoRank rank : LottoRank.values()) {
                put(rank, 0);
            }
        }};
        createTicket.allocateTicket().stream()
                .filter(lottoTicket -> lottoTicket.matchCount(winningNumber) >= 3)
                .forEach(lottoTicket -> {
                    LottoRank rank = RankTable.get(lottoTicket.matchCount(winningNumber),
                            lottoTicket.contains(winningNumber.getBonusNumber()));
                    results.put(rank, results.get(rank)+1);
                });
        LottoResults lottoResults = LottoResults.createLottoResults(createTicket.allocateTicket(), winningNumber);

        assertThat(lottoResults.getLottoResults()).isEqualTo(results);
    }

}
