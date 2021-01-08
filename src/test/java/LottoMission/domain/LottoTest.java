package LottoMission.domain;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {

    @Test
    public void create() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lotto).isEqualTo(new Lotto(Arrays.asList(2, 1, 3, 6, 4, 5)));
    }

    @Test
    public void 로또등수계산시뮬레이션() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> answerList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 7));
        int bonusNumber = 6;
        LottoAnswer answer = new LottoAnswer(
                new LottoNumbers(answerList), new LottoNumber(bonusNumber));

        lotto.winningPrize(answer);
        assertThat(lotto.getWinningsStat()).isEqualTo(LotteryWinnings.SECOND);
    }

}
