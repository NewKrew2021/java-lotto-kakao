package lotto;

import lotto.domain.*;
import lotto.domain.Number;
import org.assertj.core.util.Sets;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class LottoResultsTest {
    private LottoTickets lottoTickets;
    private WinningNumber winningNumber;

    @BeforeEach
    void setInit(){
    }

    @Test
    void createLottoResultsTest() {
        lottoTickets = CreateTicket.createAutoTicket(14000);
        winningNumber = new WinningNumber("1, 2, 3, 4, 5, 6", 7);

        LottoResults lottoResults = LottoResults.createLottoResults(lottoTickets.getLottoTickets(), winningNumber);
        assertThat(lottoResults).
                isEqualTo(LottoResults.createLottoResults(lottoTickets.getLottoTickets(), winningNumber));
    }

    @ParameterizedTest
    @CsvSource(value = {"7, 2, 10, 4, 36, 6:45:FIRST"
                    , "7, 2, 10, 1, 2, 3 : 45 : FIFTH"
                    , "7, 2, 10, 4, 36, 45 : 6 : SECOND"},  delimiter = ':')
    void getCountLottoRankTest(String number, int bonus, LottoRank rank){
        LottoTicket lottoTicket = new LottoTicket(
                Sets.newHashSet(Arrays.asList(
                        new Number(7),
                        new Number(2),
                        new Number(10),
                        new Number(4),
                        new Number(36),
                        new Number(6)))
        );
        winningNumber = new WinningNumber(number, bonus);

        LottoTickets lottoTickets = new LottoTickets(Arrays.asList(lottoTicket));
        LottoResults lottoResults = LottoResults.createLottoResults(lottoTickets.getLottoTickets(), winningNumber);
        assertThat(lottoResults.getCountLottoRank(rank)).isEqualTo(1);
    }

    @ParameterizedTest
    @CsvSource(value = {"7, 2, 10, 4, 36, 6:45: 200000000"
            , "7, 2, 10, 1, 2, 3 : 45 : 500"
            , "7, 2, 10, 4, 36, 45 : 6 : 3000000"},  delimiter = ':')
    void earningTest(String number, int bonus, int rate){
        LottoTicket lottoTicket = new LottoTicket(
                Sets.newHashSet(Arrays.asList(
                        new Number(7),
                        new Number(2),
                        new Number(10),
                        new Number(4),
                        new Number(36),
                        new Number(6)))
        );
        winningNumber = new WinningNumber(number, bonus);

        LottoTickets lottoTickets = new LottoTickets(Arrays.asList(lottoTicket));
        LottoResults lottoResults = LottoResults.createLottoResults(lottoTickets.getLottoTickets(), winningNumber);
        assertThat(lottoResults.earningRate(1000)).isEqualTo(rate);
    }

//    @Test
//    void getLottoResultsTest(){
//        Map<LottoRank, Integer> results = new HashMap<LottoRank, Integer>() {{
//            for (LottoRank rank : LottoRank.values()) {
//                put(rank, 0);
//            }
//        }};
//        createTicket.getTickets().stream()
//                .filter(lottoTicket -> lottoTicket.matchCount(winningNumber) >= 3)
//                .forEach(lottoTicket -> {
//                    LottoRank rank = RankTable.get(lottoTicket.matchCount(winningNumber),
//                            winningNumber.bonusNumberContain(lottoTicket));
//                    results.put(rank, results.get(rank)+1);
//                });
//        LottoResults lottoResults = LottoResults.createLottoResults(createTicket.getTickets(), winningNumber);

//        assertThat(lottoResults.getLottoResults()).isEqualTo(results);
    }

