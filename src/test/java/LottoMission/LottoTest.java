package LottoMission;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {

    @Test
    public void create() {
        Lotto lotto = new Lotto(new HashSet<>(Arrays.asList(1,2,3,4,5,6)));
        assertThat(lotto).isEqualTo(new Lotto(new HashSet<>(Arrays.asList(2, 1, 3, 6, 4, 5))));
    }

    @Test
    public void lottoSimulation() {
        Lotto lotto = new Lotto(new HashSet<>(Arrays.asList(1,2,3,4,5,6)));
        Set<Integer> answer = new HashSet<>(Arrays.asList(1,2,3,4,5,7));
        Integer bonusNumber = 6;

        lotto.compareToWinningNumber(answer, bonusNumber);
        LotteryWinnings lotteryWinnings = lotto.getWinningsStat();
        assertThat(lotteryWinnings).isEqualTo(LotteryWinnings.SECOND);
    }

}
