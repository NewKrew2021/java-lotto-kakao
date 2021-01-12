package lotto.domain;

import lotto.util.LottoNumberParser;
import lotto.util.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    private Lotto lotto;

    @BeforeEach
    void setUp(){
        lotto = Lotto.of(LottoNumberParser.toLottoNumbers("1, 2, 3, 4, 5, 6"));
    }

    @Test
    @DisplayName("로또 번호를 출력한다.")
    void toStringTest() {
        assertThat(lotto.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @ParameterizedTest
    @DisplayName("로또 번호와 당첨번호를 매칭하여 등수를 반환한다.")
    @MethodSource("provideMatchNumber")
    void match(MatchNumber matchNumber, Rank rank) {
        assertThat(lotto.match(matchNumber)).isEqualTo(rank);
    }

    static Stream<Arguments> provideMatchNumber() {
        return Stream.of(
                Arguments.of(MatchNumber.of("1, 2, 3, 4, 5, 6", 7), Rank.FIRST),
                Arguments.of(MatchNumber.of("1, 2, 3, 4, 5, 10", 6), Rank.SECOND),
                Arguments.of(MatchNumber.of("1, 2, 3, 4, 5, 10", 7), Rank.THIRD),
                Arguments.of(MatchNumber.of("1, 2, 3, 4, 10, 11", 7), Rank.FOURTH),
                Arguments.of(MatchNumber.of("1, 2, 3, 10, 11, 12", 7), Rank.FIFTH),
                Arguments.of(MatchNumber.of("1, 2, 10, 11, 12, 13", 7), Rank.NOTHING));
    }
}
