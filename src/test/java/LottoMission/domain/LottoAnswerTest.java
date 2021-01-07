package LottoMission.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoAnswerTest {

    @Test
    public void 정답계산() {
        Lotto lottoNumbers = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoAnswer lottoAnswer = new LottoAnswer(
                new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 7)), new Number(6));
        lottoNumbers.calculateRank(lottoAnswer);
        assertThat(lottoNumbers.calculateRank(lottoAnswer)).isEqualTo(Rank.SECOND);
    }

}


