package mission.lotto.util;

import mission.lotto.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class StatisticsTest {
    @Test
    @DisplayName("구입한 로또의 당첨 결과 및 당첨금 계산 테스트")
    public void statTests() throws LottoException {
        // given
        List<List<Integer>> numberSamples = Arrays.asList(
                Arrays.asList(8, 21, 23, 41, 42, 43),
                Arrays.asList(3, 5, 11, 16, 32, 38),
                Arrays.asList(7, 11, 16, 35, 36, 44),
                Arrays.asList(1, 8, 3, 2, 4, 5),
                Arrays.asList(1, 2, 3, 4, 5, 7),
                Arrays.asList(7, 11, 30, 40, 42, 43),
                Arrays.asList(2, 13, 22, 32, 38, 45),
                Arrays.asList(23, 25, 33, 36, 39, 41),
                Arrays.asList(1, 3, 4, 6, 22, 45),
                Arrays.asList(5, 9, 38, 41, 43, 44),
                Arrays.asList(2, 8, 9, 18, 19, 21),
                Arrays.asList(13, 14, 18, 21, 23, 35),
                Arrays.asList(17, 21, 29, 37, 42, 45),
                Arrays.asList(3, 8, 27, 30, 35, 44)
        );
        Lottos lottos = Lottos.buyLottos(14, numberSamples, new UserMoney(14000));

        // when
        LottoAnswer answer = new LottoAnswer(Arrays.asList(1, 2, 3, 4, 5, 6), 7);

        // then
        Statistics statistics = new Statistics(lottos, answer);
        Map<Rank, Integer> allLottoRankCount = statistics.getLottoRanks();
        assertThat(allLottoRankCount)
                .containsEntry(Rank.FIRST, 0)
                .containsEntry(Rank.SECOND, 1)
                .containsEntry(Rank.THIRD, 1)
                .containsEntry(Rank.FOURTH, 1)
                .containsEntry(Rank.FIFTH, 0)
                .containsEntry(Rank.UNRANKED, 11);

        assertThat(statistics.getSumAllWinningMoney()).isEqualTo(31550000);
    }

}
