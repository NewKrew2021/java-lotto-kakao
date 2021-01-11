package mission.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    @DisplayName("로또 객체 생성 테스트 : 숫자의 순서는 관계가 없다")
    public void create() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lotto).isEqualTo(new Lotto(Arrays.asList(2, 1, 3, 6, 4, 5)));
    }

    @Test
    @DisplayName("당첨 등수 계산 테스트")
    public void calculateRankTest() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoAnswer lottoAnswer = new LottoAnswer(
                new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Number(7));

        assertThat(lotto.calculateRank(lottoAnswer)).isEqualTo(Rank.FIRST);

        lottoAnswer = new LottoAnswer(
                new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 41)),
                new Number(6));
        assertThat(lotto.calculateRank(lottoAnswer)).isEqualTo(Rank.SECOND);

        lottoAnswer = new LottoAnswer(
                new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 41)),
                new Number(9));
        assertThat(lotto.calculateRank(lottoAnswer)).isEqualTo(Rank.THIRD);

        lottoAnswer = new LottoAnswer(
                new LottoNumbers(Arrays.asList(1, 2, 3, 4, 11, 13)),
                new Number(5));
        assertThat(lotto.calculateRank(lottoAnswer)).isEqualTo(Rank.FOURTH);

        lottoAnswer = new LottoAnswer(
                new LottoNumbers(Arrays.asList(1, 2, 3, 15, 16, 17)),
                new Number(5));
        assertThat(lotto.calculateRank(lottoAnswer)).isEqualTo(Rank.FIFTH);

        lottoAnswer = new LottoAnswer(
                new LottoNumbers(Arrays.asList(1, 2, 11, 22, 33, 44)),
                new Number(4));
        assertThat(lotto.calculateRank(lottoAnswer)).isEqualTo(Rank.UNRANKED);
    }

}
