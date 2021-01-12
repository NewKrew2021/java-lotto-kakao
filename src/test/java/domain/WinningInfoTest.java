package domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WinningInfoTest {

  Map<LottoRank, Integer> rankCount;

  @BeforeEach
  void setUp() {
    rankCount = new HashMap<>();
    rankCount.put(LottoRank.FIFTH, 1);
  }

  @Test
  void create() {
    WinningInfo winningInfo = new WinningInfo(rankCount);
    assertThat(winningInfo).isEqualTo(new WinningInfo(rankCount));
  }

  @Test
  void sum() {
    WinningInfo winningInfo = new WinningInfo(rankCount);
    assertThat(winningInfo.getSumPrize()).isEqualTo(5000);
  }

  @Test
  void yield() {
    WinningInfo winningInfo = new WinningInfo(rankCount);
    Amount amount = new Amount(5000);

    assertThat(winningInfo.getYield(amount)).isEqualTo(1.0);
  }
}
