package lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoManagerTest {
    @Test
    void getNumberOfLotto() {
        LottoManager lottoManager = new LottoManager();
        lottoManager.buyRandomLottos(2000);
        assertEquals(2, lottoManager.getNumberOfLottos());
    }

    @Test
    void getEarningRate() {
        LottoManager lottoManager = new LottoManager();

        lottoManager.buyManualLotto(Lotto.generateLotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottoManager.buyManualLotto(Lotto.generateLotto(Arrays.asList(11, 12, 13, 14, 15, 16)));

        Lotto winningLotto = Lotto.generateLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoNumber lottoNumber = LottoNumber.getInstance(7);

        lottoManager.checkLottos(winningLotto, lottoNumber);

        assertEquals(100000000, lottoManager.getEarningRate());
    }

    @Test
    void makeStatistics(){
        LottoManager lottoManager = new LottoManager();

        lottoManager.buyManualLotto(Lotto.generateLotto(Arrays.asList(1, 2, 3, 4, 5, 7)));
        lottoManager.buyManualLotto(Lotto.generateLotto(Arrays.asList(11, 12, 13, 14, 15, 16)));

        Lotto winningLotto = Lotto.generateLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoNumber lottoNumber = LottoNumber.getInstance(7);

        lottoManager.checkLottos(winningLotto, lottoNumber);

        assertEquals(1, lottoManager.makeStatistics().get(LottoResult.SECOND));
    }
}
