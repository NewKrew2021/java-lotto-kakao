package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.*;

public class LottoGameTest {
    @Test
    void hasMoneyTest() {
        LottoGame hasMoneySimulator = new LottoGame(1000);
        LottoGame noMoneySimulator = new LottoGame(0);

        assertThat(hasMoneySimulator.hasMoney()).isTrue();
        assertThat(noMoneySimulator.hasMoney()).isFalse();
    }

    @Test
    void buyLottoTest() {
        LottoGame lottoGame = new LottoGame(2000);

        lottoGame.buyAutoLotto();
        assertThat(lottoGame.hasMoney()).isTrue();

        lottoGame.buyAutoLotto();
        assertThat(lottoGame.hasMoney()).isFalse();
    }

    @Test
    void profitPercentageTest() {
        LottoGame lottoGame = new LottoGame(10000);
        lottoGame.addLotto(() -> Arrays.asList(1, 2, 3, 14, 15, 16));
        lottoGame.addAnswerLotto("1,2,3,4,5,6", 7);

        assertThat(lottoGame.profitPercentage()).isEqualTo(50);
    }

    @Test
    void getWinningMoneyTest() {
        LottoGame lottoGame = new LottoGame(2000);
        lottoGame.addLotto(() -> Arrays.asList(1, 2, 3, 4, 5, 6));
        lottoGame.addLotto(() -> Arrays.asList(1, 2, 3, 4, 5, 7));
        lottoGame.addAnswerLotto("1,2,3,4,5,6", 7);

        assertThat(lottoGame.getWinningMoney()).
                isEqualTo(LottoStatus.FIRST.getWinngs() + LottoStatus.SECOND.getWinngs());
    }
}
