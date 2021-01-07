package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoResultsTest {

    @Test
    void upsertTest() {
        LottoResults lottoResults = new LottoResults();
        lottoResults.upsert(LottoRank.FIRST);
        assertThat(lottoResults.getCount(LottoRank.FIRST)).isEqualTo(1);
        assertThat(lottoResults.toString()).isEqualTo("3개 일치 (5000원) - 0개\n" +
                "4개 일치 (50000원) - 0개\n" +
                "5개 일치 (1500000원) - 0개\n" +
                "5개 일치, 보너스 볼 일치 (30000000원) - 0개\n" +
                "6개 일치 (2000000000원) - 1개\n");

        lottoResults.upsert(LottoRank.FIRST);
        assertThat(lottoResults.getCount(LottoRank.FIRST)).isEqualTo(2);
        assertThat(lottoResults.toString()).isEqualTo("3개 일치 (5000원) - 0개\n" +
                "4개 일치 (50000원) - 0개\n" +
                "5개 일치 (1500000원) - 0개\n" +
                "5개 일치, 보너스 볼 일치 (30000000원) - 0개\n" +
                "6개 일치 (2000000000원) - 2개\n");
    }

    @Test
    void upsertTwoTest() {
        LottoResults lottoResults = new LottoResults();
        lottoResults.upsert(LottoRank.FIRST);
        assertThat(lottoResults.getCount(LottoRank.FIRST)).isEqualTo(1);
        assertThat(lottoResults.toString()).isEqualTo("3개 일치 (5000원) - 0개\n" +
                "4개 일치 (50000원) - 0개\n" +
                "5개 일치 (1500000원) - 0개\n" +
                "5개 일치, 보너스 볼 일치 (30000000원) - 0개\n" +
                "6개 일치 (2000000000원) - 1개\n");

        lottoResults.upsert(LottoRank.SECOND);
        assertThat(lottoResults.getCount(LottoRank.SECOND)).isEqualTo(1);
        assertThat(lottoResults.toString()).isEqualTo("3개 일치 (5000원) - 0개\n" +
                "4개 일치 (50000원) - 0개\n" +
                "5개 일치 (1500000원) - 0개\n" +
                "5개 일치, 보너스 볼 일치 (30000000원) - 1개\n" +
                "6개 일치 (2000000000원) - 1개\n");
    }

    @Test
    void upsert5thTest() {
        LottoResults lottoResults = new LottoResults();
        lottoResults.upsert(LottoRank.FIFTH);
        assertThat(lottoResults.toString()).isEqualTo("3개 일치 (5000원) - 1개\n" +
                "4개 일치 (50000원) - 0개\n" +
                "5개 일치 (1500000원) - 0개\n" +
                "5개 일치, 보너스 볼 일치 (30000000원) - 0개\n" +
                "6개 일치 (2000000000원) - 0개\n");
    }

}
