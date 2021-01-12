package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoStatisticsTest {

    private LottoStatistics lottoStatistics;

    @BeforeEach
    public void createLottos() {
        WinningLotto winningLotto = new WinningLotto(Arrays.asList(new Ball(1), new Ball(7), new Ball(8),
                new Ball(9), new Ball(10), new Ball(11)),34);
        Lottos lottos = new Lottos(
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
        lottoStatistics = new LottoStatistics(lottos.getRankCounts(winningLotto), lottos.getAutoLottos().size());
    }

    @Test
    public void calculateTotalRewardTest() {
        assertThat(lottoStatistics.calculateTotalReward()).isEqualTo(1709532704);
        System.out.println(lottoStatistics.toString());
    }

    @Test
    public void calculateEarningsRateTest() {
        assertThat(lottoStatistics.calculateEarningsRate(6000)).isEqualTo(284922.0);
        assertThat(lottoStatistics.calculateEarningsRate(6061500000L)).isEqualTo(0.0);
    }
}
