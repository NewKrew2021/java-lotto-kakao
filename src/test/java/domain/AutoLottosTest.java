package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoLottosTest {
    private Lottos lottos;
    private WinningLotto winningLotto;

    @BeforeEach
    public void createLottos() {
        winningLotto = new WinningLotto(Arrays.asList(new Ball(1), new Ball(7), new Ball(8),
                new Ball(9), new Ball(10), new Ball(11)),34);
        lottos = new Lottos(
                Arrays.asList(
                        new Lotto(Arrays.asList(new Ball(1), new Ball(7), new Ball(8),
                                new Ball(9), new Ball(10), new Ball(11))),
                        new Lotto(Arrays.asList(new Ball(1), new Ball(7), new Ball(8),
                                new Ball(9), new Ball(10), new Ball(11))),
                        new Lotto(Arrays.asList(new Ball(1), new Ball(7), new Ball(8),
                                new Ball(9), new Ball(10), new Ball(11))),
                        new Lotto(Arrays.asList(new Ball(1), new Ball(7), new Ball(8),
                                new Ball(9), new Ball(10), new Ball(13))),
                        new Lotto(Arrays.asList(new Ball(1), new Ball(7), new Ball(8),
                                new Ball(9), new Ball(10), new Ball(13))),
                        new Lotto(Arrays.asList(new Ball(1), new Ball(7), new Ball(8),
                                new Ball(9), new Ball(10), new Ball(13)))
                )
        );
    }

    @Test
    void getRankCounts(){
        HashMap<LottoRank, Integer> rankCounts = lottos.getRankCounts(winningLotto);
        assertThat(rankCounts.get(LottoRank.FIRST)).isEqualTo(3);
        assertThat(rankCounts.get(LottoRank.THIRD)).isEqualTo(3);
    }
}
