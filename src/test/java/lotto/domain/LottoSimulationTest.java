package lotto.domain;

import lotto.utils.Result;
import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

public class LottoSimulationTest {
    @Test
    void testGetYield() {
        LottoSimulation lottoSimulation = new LottoSimulation(
                new Price(14000),
                new WinningLotto(Lotto.of("1, 2, 3, 4, 5, 6"), new LottoNumber(7)),
                new Lottos(new String[] { "4, 5, 6, 7, 8, 9" })
        );

        lottoSimulation.confirm();
        assertThat(lottoSimulation.getYield()).isCloseTo(0.35, offset(0.01));
    }
}
