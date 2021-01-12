package lotto.domain;

import lotto.util.MatchResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

class MatchNumberTest {

    @Test
    @DisplayName("보너스 번호가 당첨번호와 동일하면 예외 발생.")
    void create_duplicate() {
        assertThatNoException().isThrownBy(() -> {
            MatchNumber.of("1, 2, 3, 4, 5, 6", 6);
        });
    }

    @ParameterizedTest
    @DisplayName("MatchNumber와 해당 로또번호를 매치한 결과를 반환한다.")
    @MethodSource("provideLottoNumber")
    void getMatchResult(LottoNumber lottoNumber, MatchResult expected) {
        MatchNumber matchNumber = MatchNumber.of("1, 2, 3, 4, 5, 6", 7);
        assertThat(matchNumber.getMatchResult(lottoNumber)).isEqualTo(expected);
    }

    static Stream<Arguments> provideLottoNumber() {
        return Stream.of(Arguments.of(LottoNumber.of(1), MatchResult.WIN),
                Arguments.of(LottoNumber.of(7), MatchResult.BONUS),
                Arguments.of(LottoNumber.of(10), MatchResult.NOTHING));
    }
}
