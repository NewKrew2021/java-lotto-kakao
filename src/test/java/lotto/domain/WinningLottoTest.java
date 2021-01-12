package lotto.domain;

import lotto.utils.Result;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class WinningLottoTest {
    private final Lotto lotto = Lotto.of("1, 2, 3, 4, 5, 6");
    private final WinningLotto winningLotto = new WinningLotto(lotto, new LottoNumber(10));

    @ParameterizedTest
    @MethodSource("lottoCompare")
    void testLottoCompare(String lottoNumbers, Result result) {
        assertThat(winningLotto.compare(Lotto.of(lottoNumbers))).isEqualTo(result);
    }

    static Stream<Arguments> lottoCompare() {
        return Stream.of(
                arguments("5, 6, 7, 8, 9, 10", Result.UNDERTHREE),
                arguments("4, 5, 6, 7, 8, 9", Result.THREE),
                arguments("3, 4, 5, 6, 7, 8", Result.FOUR),
                arguments("2, 3, 4, 5, 6, 9", Result.FIVE),
                arguments("2, 3, 4, 5, 6, 10", Result.BONUSFIVE),
                arguments("1, 2, 3, 4, 5, 6", Result.SIX)
        );
    }

    @Test
    void testCreate() {
        assertThat(winningLotto).isEqualTo(new WinningLotto(lotto, new LottoNumber(10)));
    }
}
