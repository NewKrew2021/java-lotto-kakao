package domain;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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
}
