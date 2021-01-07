package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoStatisticsTest {

    private LottoStatistics lottoStatistics;

    @BeforeEach
    public void createLottos() {
        Lotto winningLotto = new Lotto(Arrays.asList(1, 7, 8, 9, 10, 11), 12);
        Lottos lottos = new Lottos(
                Arrays.asList(
                        new Lotto(Arrays.asList(1, 7, 8, 9, 10, 11), 12),
                        new Lotto(Arrays.asList(1, 7, 8, 9, 10, 11), 12),
                        new Lotto(Arrays.asList(1, 7, 8, 9, 10, 11), 12),
                        new Lotto(Arrays.asList(1, 7, 8, 9, 10, 13), 12),
                        new Lotto(Arrays.asList(1, 7, 8, 9, 10, 13), 12),
                        new Lotto(Arrays.asList(1, 7, 8, 9, 10, 13), 14)
                )
        );
        lottoStatistics = lottos.getLottoStatistics(winningLotto, 6);
    }

    @Test
    public void calculateTotalRewardTest() {
        assertThat(lottoStatistics.calculateTotalReward()).isEqualTo(new BigDecimal("6061500000"));
        System.out.println(lottoStatistics.toString());
    }

    @Test
    public void calculateEarningsRateTest() {
        assertThat(lottoStatistics.calculateEarningsRate(new BigDecimal("6000"))).isEqualTo(new BigDecimal("101025000"));
        assertThat(lottoStatistics.calculateEarningsRate(new BigDecimal("6061500000"))).isEqualTo(new BigDecimal("100"));
    }
}
