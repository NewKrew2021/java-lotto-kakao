package domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

public class LottoRankTest {

  @Test
  void create() {
    LottoRank lottoRank = LottoRank.of(1);
    assertThat(lottoRank).isEqualTo(LottoRank.FIRST);
  }

  @Test
  void sumPrize() {
    LottoRank lottoRank = LottoRank.of(5);
    assertThat(lottoRank.sumPrize(1)).isEqualTo(5000L);
  }
}
