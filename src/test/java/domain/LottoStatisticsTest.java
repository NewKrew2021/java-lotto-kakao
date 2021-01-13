package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoStatisticsTest {

    private LottoStatistics lottoStatistics;

    @BeforeEach
    public void createLottos() {
        WinningLotto winningLotto = new WinningLotto(LottoTest.getLottoBalls(1, 7, 8, 9, 10, 11), 34);
        Lottos lottos = new Lottos(
                Arrays.asList(
                        new Lotto(LottoTest.getLottoBalls(1, 7, 8, 9, 10, 11)),
                        new Lotto(LottoTest.getLottoBalls(1, 7, 8, 9, 10, 11)),
                        new Lotto(LottoTest.getLottoBalls(1, 7, 8, 9, 10, 11)),
                        new Lotto(LottoTest.getLottoBalls(1, 7, 8, 9, 10, 13)),
                        new Lotto(LottoTest.getLottoBalls(1, 7, 8, 9, 10, 13)),
                        new Lotto(LottoTest.getLottoBalls(1, 7, 8, 9, 10, 13))
                )
        );
        lottoStatistics = new LottoStatistics(lottos.getRankCounts(winningLotto), lottos.getLottos().size());
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
