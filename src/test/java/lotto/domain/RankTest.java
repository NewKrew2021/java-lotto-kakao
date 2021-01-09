package lotto.domain;

import lotto.domain.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;


public class RankTest {

    @ParameterizedTest
    @DisplayName("매치되는 로또 번호 개수와 보너스볼 여부에 따라 랭크가 정상적으로 생성되는지 확인한다.")
    @CsvSource({"6, false, FIRST",
            "5, true, SECOND",
            "5, false, THIRD",
            "4, true, FOURTH",
            "3, false, FIFTH",
            "2, true, NOTHING"})
    void createTest(int matchedCount, boolean hasBouns, Rank rank) {
        assertThat(Rank.createRank(matchedCount, hasBouns)).isEqualTo(rank);
    }
}
