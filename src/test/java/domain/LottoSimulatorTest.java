package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.*;

public class LottoSimulatorTest {

    @Test
    void profitPercentageTest() {
        Lottos lottos = new Lottos(Arrays.asList( new Lotto(Arrays.asList(1,2,3,14,15,16))));
        Answer answer = new Answer("1,2,3,4,5,6", 7);
        LottoSimulator lottoSimulator = new LottoSimulator(10000, lottos, answer);
        assertThat(lottoSimulator.profitPercentage()).isEqualTo(-50);

    }

    @Test
    void getWinningMoneyTest() {
        Lottos lottos = new Lottos(Arrays.asList(new Lotto(Arrays.asList(1,2,3,4,5,6)),
                new Lotto(Arrays.asList(1,2,3,4,5,7))));
        Answer answer = new Answer("1,2,3,4,5,6", 7);
        LottoSimulator lottoSimulator = new LottoSimulator(10000, lottos, answer);

        assertThat(lottoSimulator.getWinningMoney()).
                isEqualTo(LottoStatus.FIRST.getWinnings() + LottoStatus.SECOND.getWinnings());
    }
}
