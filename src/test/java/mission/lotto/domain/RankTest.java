package mission.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    static Stream<Arguments> underThirdGenerator() {
        return Stream.of(
                Arguments.of(6, false, Rank.FIRST),
                Arguments.of(5, true, Rank.SECOND),
                Arguments.of(5, false, Rank.THIRD),
                Arguments.of(4, true, Rank.FOURTH),
                Arguments.of(4, false, Rank.FOURTH),
                Arguments.of(3, true, Rank.FIFTH),
                Arguments.of(3, false, Rank.FIFTH),
                Arguments.of(2, true, Rank.UNRANKED),
                Arguments.of(2, false, Rank.UNRANKED)
        );
    }

    @ParameterizedTest
    @MethodSource("underThirdGenerator")
    @DisplayName("Rank 가져오기 테스트")
    public void rankTest(int correctNo, boolean hasBonus, Rank expected) {
        // given
        Rank actual = Rank.getRank(correctNo, hasBonus);

        // when
        boolean compare = (actual == expected);

        // then
        assertThat(compare).isTrue();
    }

}
