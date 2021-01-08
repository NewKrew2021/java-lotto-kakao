package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class LottoResultsTest {
    private final int TEST_LOOP_TIMES = 5;

    @Test
    void upsertTest() {
        LottoResults lottoResults = new LottoResults();
        for (int i = 1; i <= TEST_LOOP_TIMES; i++) {
            upsertAllRanksAndTest(lottoResults, i);
        }
    }

    private void upsertAllRanksAndTest(LottoResults lottoResults, int comp) {
        for (LottoRank lottoRank : LottoRank.values()) {
            lottoResults.upsert(lottoRank);
            assertThat(lottoResults.getCount(lottoRank)).isEqualTo(comp);
        }
        System.out.println(lottoResults);
    }

    @Test
    @DisplayName("수익률 계산 테스트")
    void calculateRateTest() {
        LottoResults lottoResults = new LottoResults();
        lottoResults.upsert(LottoRank.FIFTH);
        assertThat(lottoResults.calculateRate(14000)).isEqualTo(0.35);
    }

}
