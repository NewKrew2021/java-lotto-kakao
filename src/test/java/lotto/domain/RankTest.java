package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Rank 클래스")
public class RankTest {

    @DisplayName("matchCount와 보너스볼 일치여부를 받아 랭크를 반환하는 기능 테스트")
    @ParameterizedTest
    @CsvSource(delimiter = ':',
            value = {
                    "6:false:FIRST",
                    "5:true:SECOND",
                    "5:false:THIRD",
                    "4:false:FOURTH",
                    "3:false:FIFTH",
                    "2:false:OUT",
                    "1:false:OUT"
            }
    )
    public void getRankAccordingToTest(int matchCount, boolean matchBonusBall, Rank rank) {
        assertThat(
                Rank.getRankAccordingTo(
                        matchCount, matchBonusBall
                )
        ).isEqualTo(rank);
    }
}