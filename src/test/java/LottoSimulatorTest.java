import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.*;

public class LottoSimulatorTest {
    @Test
    void hasMoneyTest() {
        LottoSimulator hasMoneySimulator = new LottoSimulator(1000);
        LottoSimulator noMoneySimulator = new LottoSimulator(0);

        assertThat(hasMoneySimulator.hasMoney()).isTrue();
        assertThat(noMoneySimulator.hasMoney()).isFalse();
    }

    @Test
    void buyLottoTest() {
        LottoSimulator lottoSimulator = new LottoSimulator(2000);
        lottoSimulator.buyAutoLotto();
        assertThat(lottoSimulator.hasMoney()).isTrue();

        lottoSimulator.buyAutoLotto();
        assertThat(lottoSimulator.hasMoney()).isFalse();
    }

    @Test
    void profitPercentageTest() {
        LottoSimulator lottoSimulator = new LottoSimulator(10000);
        lottoSimulator.addLotto(() -> Arrays.asList(1,2,3,14,15,16));
        lottoSimulator.addAnswerLotto(Arrays.asList(1,2,3,4,5,6), 7);
        lottoSimulator.setLottoManager();
        assertThat(lottoSimulator.profitPercentage()).isEqualTo(50);

    }

    @Test
    void getWinningMoneyTest() {
        LottoSimulator lottoSimulator = new LottoSimulator(2000);
        lottoSimulator.addLotto(() -> Arrays.asList(1,2,3,4,5,6));
        lottoSimulator.addLotto(() -> Arrays.asList(1,2,3,4,5,7));
        lottoSimulator.addAnswerLotto(Arrays.asList(1,2,3,4,5,6), 7);
        lottoSimulator.setLottoManager();
        assertThat(lottoSimulator.getWinningMoney()).
                isEqualTo(LottoStatus.FIRST.getWinngs() + LottoStatus.SECOND.getWinngs());
    }
}
