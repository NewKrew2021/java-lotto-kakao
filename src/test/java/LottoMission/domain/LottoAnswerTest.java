package LottoMission.domain;

import LottoMission.domain.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoAnswerTest {

    @Test
    public void 정답계산() {
        Lotto lottoNumbers = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoAnswer lottoAnswer = new LottoAnswer(
                new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 7)), new LottoNumber(6));
        lottoNumbers.winningPrize(lottoAnswer);
        assertThat(lottoNumbers.getWinningsStat()).isEqualTo(LotteryWinnings.SECOND);
    }

}


