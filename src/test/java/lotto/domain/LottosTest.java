package lotto.domain;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    private Lottos lottos;

    @BeforeEach
    public void setUp() {
        lottos = new Lottos(Arrays.asList(Arrays.asList(1, 2, 3, 4, 5, 6), Arrays.asList(7, 8, 9, 10, 11, 12)), 3);
    }

    @Test
    @DisplayName("추첨을 통한 정확도 테스트")
    public void raffleTest() {
        WinningLotto winningNumber = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 8);
        assertThat(lottos.raffle(winningNumber).getCountOfRank(Rank.FIRST)).isEqualTo(1);
    }

    @Test
    @DisplayName("추첨을 통한 정확도 테스트")
    void bonusTest() {
        WinningLotto winningNumber = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 7), 6);
        assertThat(lottos.raffle(winningNumber).getCountOfRank(Rank.SECOND)).isEqualTo(1);
    }
}
