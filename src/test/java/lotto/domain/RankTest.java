package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Rank 클래스")
public class RankTest {

    @DisplayName("matchCount와 보너스볼 일치여부를 받아 랭크를 반환하는 기능 테스트")
    @ParameterizedTest
    @MethodSource("provideMatchCountAndMatchBonusBallAndRank")
    public void getRankArccordingToTest(int matchCount, boolean matchBonusBall, Rank rank){
        assertThat(
                Rank.getRankAccordingTo(
                        matchCount, matchBonusBall
                )
        ).isEqualTo(rank);
    }

    private static Stream<Arguments> provideMatchCountAndMatchBonusBallAndRank(){
        return Stream.of(
                Arguments.of(6, false, Rank.FIRST),
                Arguments.of(5, true, Rank.SECOND),
                Arguments.of(5, false, Rank.THIRD),
                Arguments.of(4, false, Rank.FOURTH),
                Arguments.of(3, false, Rank.FIFTH),
                Arguments.of(2, false, Rank.OUT),
                Arguments.of(1, false, Rank.OUT)
        );
    }
}
