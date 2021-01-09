package lotto;

import lotto.domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {
    @ParameterizedTest
    @CsvSource({"6,false,FIRST", "5,true,SECOND", "5,false,THIRD", "4,true,FOURTH"})
    @DisplayName("Rank 판단 테스트")
    void createTest(int matchedCount, boolean hasBonus, Rank rank) {
        assertThat(Rank.createRank(matchedCount, hasBonus)).isEqualTo(rank);
    }
}
