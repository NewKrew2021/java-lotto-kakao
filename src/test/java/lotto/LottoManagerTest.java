package lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoManagerTest {

    @Test
    void getNumberOfLotto() {
        LottoManager lottoManager = new LottoManager();

        lottoManager.buyRandomLotto();
        lottoManager.buyRandomLotto();
        lottoManager.buyManualLotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertEquals(3, lottoManager.getNumberOfLottos());
    }

    @Test
    void getEarningRate() {
        LottoManager lottoManager = new LottoManager();

        lottoManager.buyManualLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        lottoManager.buyManualLotto(Arrays.asList(11, 12, 13, 14, 15, 16));

        List<Integer> winningLotto = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        lottoManager.checkLottos(winningLotto, bonusNumber);

        assertEquals(1_000_000, lottoManager.getEarningRate());
    }

    @Test
    void makeStatistics(){
        LottoManager lottoManager = new LottoManager();

        lottoManager.buyManualLotto(Arrays.asList(1, 2, 3, 4, 5, 7));
        lottoManager.buyManualLotto(Arrays.asList(11, 12, 13, 14, 15, 16));

        List<Integer> winningLotto = Arrays.asList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        lottoManager.checkLottos(winningLotto, bonusNumber);

        assertEquals(1, lottoManager.makeStatistics().get(LottoResult.SECOND));
    }

}
