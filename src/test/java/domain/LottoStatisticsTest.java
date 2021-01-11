package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoStatisticsTest {

    private LottoStatistics lottoStatistics;

    @Test
    public void createLottos() {
        WinningLotto winningLotto = new WinningLotto(Arrays.asList(1, 7, 8, 9, 10, 11),15);
        Lottos lottos = new Lottos(
                Arrays.asList(
                        new Lotto(Arrays.asList(1, 7, 8, 9, 10, 11)),
                        new Lotto(Arrays.asList(1, 7, 8, 9, 10, 11)),
                        new Lotto(Arrays.asList(1, 7, 8, 9, 10, 11)),
                        new Lotto(Arrays.asList(1, 7, 8, 9, 10, 13)),
                        new Lotto(Arrays.asList(1, 7, 8, 9, 10, 13)),
                        new Lotto(Arrays.asList(1, 7, 8, 9, 10, 13))
                )
        );
    }

    @Test
    public void calculateTotalRewardTest() {
        assertThat(lottoStatistics.calculateTotalReward()).isEqualTo(6061500000L);
        System.out.println(lottoStatistics.toString());
    }

    @Test
    public void calculateEarningsRateTest() {
        assertThat(lottoStatistics.calculateEarningsRate(6000)).isEqualTo(101025000);
        assertThat(lottoStatistics.calculateEarningsRate(6061500000L)).isEqualTo(100);
    }
}
