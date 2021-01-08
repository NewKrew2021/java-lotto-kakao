package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class MatchNumberTest {

    @ParameterizedTest
    @DisplayName("MatchNumber와 해당 로또번호를 매치한 결과를 반환한다.")
    @MethodSource("provideLottoNumber")
    void getMatchResult(LottoNumber lottoNumber, MatchResult expected) {
        MatchNumber matchNumber = MatchNumber.of("1, 2, 3, 4, 5, 6", 7);
        Assertions.assertThat(matchNumber.getMatchResult(lottoNumber)).isEqualTo(expected);
    }

    static Stream<Arguments> provideLottoNumber() {
        return Stream.of(Arguments.of(LottoNumber.of(1), MatchResult.WIN),
                Arguments.of(LottoNumber.of(7), MatchResult.BONUS),
                Arguments.of(LottoNumber.of(10), MatchResult.NOTHING));
    }
}
