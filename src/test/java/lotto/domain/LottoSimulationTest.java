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
        LottoResults lottoResults = new LottoResults(Collections.singletonList(
                Result.THREE
        ));
        LottoSimulation lottoSimulation = new LottoSimulation(14000, lottoResults);

        assertThat(lottoSimulation.getYield()).isCloseTo(0.35, offset(0.01));
    }
}
