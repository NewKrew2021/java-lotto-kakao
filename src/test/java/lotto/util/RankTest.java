package lotto.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @ParameterizedTest
    @DisplayName("당첨번호와 보너스번호 매칭 개수로 몇 등인지 구한다.")
    @MethodSource("provideRank")
    void of(int winCount, int bonusCount, Rank rank) {
        assertThat(Rank.of(winCount, bonusCount)).isEqualTo(rank);
    }

    static Stream<Arguments> provideRank() {
        return Stream.of(
                Arguments.of(6, 0, Rank.FIRST),
                Arguments.of(5, 1, Rank.SECOND),
                Arguments.of(5, 0, Rank.THIRD),
                Arguments.of(4, 1, Rank.FOURTH),
                Arguments.of(3, 0, Rank.FIFTH),
                Arguments.of(2, 1, Rank.NOTHING));
    }
}
