package mission.lotto.util;

import mission.lotto.domain.Number;
import mission.lotto.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class StatisticsTest {
    @Test
    @DisplayName("구입한 로또의 당첨 결과 및 당첨금 계산 테스트")
    public void 당첨통계테스트() {
        Lottos lottos1 = new Lottos(Arrays.asList(
                new Lotto(Arrays.asList(8, 21, 23, 41, 42, 43)),
                new Lotto(Arrays.asList(3, 5, 11, 16, 32, 38)),
                new Lotto(Arrays.asList(7, 11, 16, 35, 36, 44)),
                new Lotto(Arrays.asList(1, 8, 3, 2, 4, 5)),
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)),
                new Lotto(Arrays.asList(7, 11, 30, 40, 42, 43)),
                new Lotto(Arrays.asList(2, 13, 22, 32, 38, 45)),
                new Lotto(Arrays.asList(23, 25, 33, 36, 39, 41)),
                new Lotto(Arrays.asList(1, 3, 4, 6, 22, 45)),
                new Lotto(Arrays.asList(5, 9, 38, 41, 43, 44)),
                new Lotto(Arrays.asList(2, 8, 9, 18, 19, 21)),
                new Lotto(Arrays.asList(13, 14, 18, 21, 23, 35)),
                new Lotto(Arrays.asList(17, 21, 29, 37, 42, 45)),
                new Lotto(Arrays.asList(3, 8, 27, 30, 35, 44))
        ));

        LottoAnswer answer = new LottoAnswer(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), new Number(7));

        Map<Rank, Integer> allLottoRankCount = Statistics.getAllLottoRank(lottos1, answer);
        assertThat(allLottoRankCount)
                .containsEntry(Rank.FIRST, 0)
                .containsEntry(Rank.SECOND, 1)
                .containsEntry(Rank.THIRD, 1)
                .containsEntry(Rank.FOURTH, 1)
                .containsEntry(Rank.FIFTH, 0)
                .containsEntry(Rank.UNRANKED, 11);

        assertThat(Statistics.getSumAllWinningMoney(lottos1, answer)).isEqualTo(31550000);
    }

}
