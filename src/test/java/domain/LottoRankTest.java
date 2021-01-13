package domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

public class LottoRankTest {

  @Test
  void create() {
    LottoRank lottoRank = LottoRank.of(6, false);
    assertThat(lottoRank).isEqualTo(LottoRank.FIRST);
  }

  @Test
  void sumPrize() {
    LottoRank lottoRank = LottoRank.of(3, false);
    assertThat(lottoRank.sumPrize(1)).isEqualTo(5000L);
  }
}
