package lotto;

import lotto.domain.*;
import lotto.domain.Number;
import org.assertj.core.util.Sets;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class LottoResultsTest {
    Map<LottoRank, Integer> results;

    @BeforeEach
    void setInit(){
        results = new HashMap<LottoRank, Integer>();
        results.put(LottoRank.FIRST, 1);
        results.put(LottoRank.FIFTH, 10);
        results.put(LottoRank.SECOND, 2);
    }

    @ParameterizedTest
    @CsvSource(value = {"FIRST, 1", "FIFTH, 10", "SECOND, 2"})
    void getCountLottoRankTest(LottoRank rank, int matchNumber){
        LottoResults lottoResults = new LottoResults(results);
        assertThat(lottoResults.getCountLottoRank(rank)).isEqualTo(matchNumber);
    }

    @Test
    void getCountNoRankTest(){
        LottoResults lottoResults = new LottoResults(results);
        assertThat(lottoResults.getCountLottoRank(LottoRank.FOURTH)).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource(value = {"10000, 20600500", "5000, 41201000", "1000, 206005000"})
    void earningTest(int price, int rate){
        LottoResults lottoResults = new LottoResults(results);
        assertThat(lottoResults.earningRate(price)).isEqualTo(rate);
    }

}

