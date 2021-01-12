package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.*;

public class LottoResultsTest {
    private final int TEST_LOOP_TIMES = 5;

    @Test
    @DisplayName("당첨된 결과 저장 테스트")
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
    }

    @Test
    @DisplayName("수익률 계산 테스트")
    void calculateRateTest() {
        LottoResults lottoResults = new LottoResults();
        lottoResults.upsert(LottoRank.FIFTH);
        assertThat(lottoResults.calculateRate()).isEqualTo(new BigDecimal("5.00"));

        for (int i = 0; i < 13; i++) {
            lottoResults.upsert(LottoRank.NOTHING);
        }
        assertThat(lottoResults.calculateRate()).isEqualTo(new BigDecimal("0.35"));
    }

    @Test
    @DisplayName("equals 테스트")
    void equalsTest() {
        LottoResults lottoResults = new LottoResults();
        lottoResults.upsert(LottoRank.FIRST);

        LottoResults comparedResults = new LottoResults();
        comparedResults.upsert(LottoRank.FIRST);
        assertThat(lottoResults).isEqualTo(comparedResults);
    }

}
