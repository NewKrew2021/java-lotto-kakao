package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoRankTest {

    @Test
    void getRankTest() {
        assertThat(LottoRank.get(6, false)).isEqualTo(LottoRank.FIRST);
        assertThat(LottoRank.get(5, true)).isEqualTo(LottoRank.SECOND);
        assertThat(LottoRank.get(5, false)).isEqualTo(LottoRank.THIRD);
        assertThat(LottoRank.get(4, false)).isEqualTo(LottoRank.FOURTH);
        assertThat(LottoRank.get(3, false)).isEqualTo(LottoRank.FIFTH);

        assertThat(LottoRank.get(4, true)).isEqualTo(LottoRank.FOURTH);
        assertThat(LottoRank.get(3, true)).isEqualTo(LottoRank.FIFTH);
    }

    @Test
    @DisplayName("NOTHING을 제외한 리스트 생성 테스트")
    void valuesExceptNothingTest() {
        List<LottoRank> lottoRanks = Arrays.asList(LottoRank.FIRST,
                LottoRank.SECOND,
                LottoRank.THIRD,
                LottoRank.FOURTH,
                LottoRank.FIFTH);

        assertThat(LottoRank.valuesExceptNothing()).containsExactlyInAnyOrderElementsOf(lottoRanks);
        assertThat(LottoRank.valuesExceptNothing()).doesNotContain(LottoRank.NOTHING);
    }

    @Test
    @DisplayName("getPrice 테스트")
    void getPriceTest() {
        assertThat(LottoRank.FIRST.getPrice()).isEqualTo(2_000_000_000);
        assertThat(LottoRank.SECOND.getPrice()).isEqualTo(30_000_000);
        assertThat(LottoRank.THIRD.getPrice()).isEqualTo(1_500_000);
        assertThat(LottoRank.FOURTH.getPrice()).isEqualTo(50_000);
        assertThat(LottoRank.FIFTH.getPrice()).isEqualTo(5_000);
    }
}
