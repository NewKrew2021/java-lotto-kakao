package lotto;

import lotto.domain.*;
import lotto.domain.Number;
import org.assertj.core.util.Sets;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class LottoResultsTest {
    Map<LottoRank, Integer> results;

    @BeforeEach
    void setInit(){
        results = new HashMap<LottoRank, Integer>();
    }

    @ParameterizedTest
    @CsvSource(value = {"FIRST, 2", "FIFTH, 10", "SECOND, 3"})
    void getCountLottoRankTest(LottoRank rank, int matchNumber){
        results.put(rank, matchNumber);
        LottoResults lottoResults = new LottoResults(results);
        assertThat(lottoResults.getCountLottoRank(rank)).isEqualTo(matchNumber);
    }

    @ParameterizedTest
    @CsvSource(value = {"FIRST, 1, 20000000", "FIFTH, 10, 500", "SECOND, 2, 60000000"})
    void earningTest(LottoRank rank, int matchNumber, int rate){
        results.put(rank, matchNumber);
        LottoResults lottoResults = new LottoResults(results);
        assertThat(lottoResults.earningRate(10000)).isEqualTo(rate);
    }

}

