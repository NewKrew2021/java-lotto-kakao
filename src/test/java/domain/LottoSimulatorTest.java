package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.*;

public class LottoSimulatorTest {

    @Test
    void profitPercentageTest() {
        Lottos lottos = new Lottos(Arrays.asList( new Lotto(new SelfLottoStrategy("1,2,3,14,15,16"))));
        Answer answer = new Answer(new Lotto(new SelfLottoStrategy("1,2,3,4,5,6")), 7);
        PurchaseInfo purchaseInfo = new PurchaseInfo(1000, 0);
        LottoSimulator lottoSimulator = new LottoSimulator(lottos, answer);
        assertThat(lottoSimulator.getProfit()).isEqualTo(4.0);
    }

    @Test
    void getWinningMoneyTest() {
        Lottos lottos = new Lottos(Arrays.asList(new Lotto(new SelfLottoStrategy("1,2,3,4,5,6")),
                new Lotto(new SelfLottoStrategy("1,2,3,4,5,7"))));
        Answer answer = new Answer(new Lotto(new SelfLottoStrategy("1,2,3,4,5,6")), 7);
        PurchaseInfo purchaseInfo = new PurchaseInfo(2000, 0);
        LottoSimulator lottoSimulator = new LottoSimulator(lottos, answer);

        assertThat(lottoSimulator.getWinningMoney()).
                isEqualTo(LottoStatus.FIRST.getWinnings() + LottoStatus.SECOND.getWinnings());
    }
}
