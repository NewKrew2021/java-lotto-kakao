package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoResultTest {

    @Test
    void 삼등() {
        LottoResult lottoResult = new LottoResult(new AnswerLotto(new Lotto(Arrays.asList(1,2,3,4,5,6)),
                new LottoNumber(7)), new Lottos(new ArrayList<>(Arrays.asList(new Lotto(Arrays.asList(1,2,3,4,5,8))))));

        assertThat(lottoResult.getLottoResult().get(LottoStatus.FIRST)).isEqualTo(0);
        assertThat(lottoResult.getLottoResult().get(LottoStatus.SECOND)).isEqualTo(0);
        assertThat(lottoResult.getLottoResult().get(LottoStatus.THIRD)).isEqualTo(1);
        assertThat(lottoResult.getLottoResult().get(LottoStatus.FOURTH)).isEqualTo(0);
        assertThat(lottoResult.getLottoResult().get(LottoStatus.FIFTH)).isEqualTo(0);
        assertThat(lottoResult.getLottoResult().get(LottoStatus.NONE)).isEqualTo(0);
    }

    @Test
    void 이등() {
        LottoResult lottoResult = new LottoResult(new AnswerLotto(new Lotto(Arrays.asList(1,2,3,4,5,6)),
                new LottoNumber(7)), new Lottos(new ArrayList<>(Arrays.asList(new Lotto(Arrays.asList(1,2,3,4,5,7))))));

        assertThat(lottoResult.getLottoResult().get(LottoStatus.FIRST)).isEqualTo(0);
        assertThat(lottoResult.getLottoResult().get(LottoStatus.SECOND)).isEqualTo(1);
        assertThat(lottoResult.getLottoResult().get(LottoStatus.THIRD)).isEqualTo(0);
        assertThat(lottoResult.getLottoResult().get(LottoStatus.FOURTH)).isEqualTo(0);
        assertThat(lottoResult.getLottoResult().get(LottoStatus.FIFTH)).isEqualTo(0);
        assertThat(lottoResult.getLottoResult().get(LottoStatus.NONE)).isEqualTo(0);
    }

    @Test
    void 일등() {
        LottoResult lottoResult = new LottoResult(new AnswerLotto(new Lotto(Arrays.asList(1,2,3,4,5,6)),
                new LottoNumber(7)), new Lottos(new ArrayList<>(Arrays.asList(new Lotto(Arrays.asList(1,2,3,4,5,6))))));

        assertThat(lottoResult.getLottoResult().get(LottoStatus.FIRST)).isEqualTo(1);
        assertThat(lottoResult.getLottoResult().get(LottoStatus.SECOND)).isEqualTo(0);
        assertThat(lottoResult.getLottoResult().get(LottoStatus.THIRD)).isEqualTo(0);
        assertThat(lottoResult.getLottoResult().get(LottoStatus.FOURTH)).isEqualTo(0);
        assertThat(lottoResult.getLottoResult().get(LottoStatus.FIFTH)).isEqualTo(0);
        assertThat(lottoResult.getLottoResult().get(LottoStatus.NONE)).isEqualTo(0);
    }

    @Test
    @DisplayName("상금 테스트")
    void winngMoneyTest() {
        LottoResult lottoResult = new LottoResult(new AnswerLotto(new Lotto(Arrays.asList(1,2,3,4,5,6)),
                new LottoNumber(7)), new Lottos(new ArrayList<>(Arrays.asList(new Lotto(Arrays.asList(1,2,3,4,5,6))))));

        assertThat(lottoResult.getWinningMoney()).isEqualTo(LottoStatus.FIRST.getWinngs());
    }
}

