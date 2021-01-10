package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoResultsTest {

    @Test
    void upsertTest() {
        LottoResults lottoResults = new LottoResults();
        lottoResults.updateOrInsert(LottoRank.FIRST);
        assertThat(lottoResults.getCount(LottoRank.FIRST)).isEqualTo(1);
        assertThat(lottoResults.toString())
                .contains("6개 일치 (2000000000원) - 1개");

        lottoResults.updateOrInsert(LottoRank.FIRST);
        assertThat(lottoResults.getCount(LottoRank.FIRST)).isEqualTo(2);
        assertThat(lottoResults.toString())
                .contains("6개 일치 (2000000000원) - 2개");
    }

    @Test
    void upsertTwoTest() {
        LottoResults lottoResults = new LottoResults();
        lottoResults.updateOrInsert(LottoRank.FIRST);
        assertThat(lottoResults.getCount(LottoRank.FIRST)).isEqualTo(1);
        assertThat(lottoResults.toString())
                .contains("6개 일치 (2000000000원) - 1개");

        lottoResults.updateOrInsert(LottoRank.SECOND);
        assertThat(lottoResults.getCount(LottoRank.SECOND)).isEqualTo(1);
        assertThat(lottoResults.toString())
                .contains("5개 일치, 보너스 볼 일치 (30000000원) - 1개")
                .contains("6개 일치 (2000000000원) - 1개");
    }

    @Test
    void upsert5thTest() {
        LottoResults lottoResults = new LottoResults();
        lottoResults.updateOrInsert(LottoRank.FIFTH);
        assertThat(lottoResults.toString())
                .contains("3개 일치 (5000원) - 1개");
    }

}
