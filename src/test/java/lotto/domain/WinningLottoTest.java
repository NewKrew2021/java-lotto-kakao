package lotto.domain;

import lotto.utils.Result;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class WinningLottoTest {
    private Lotto lotto = new Lotto(Arrays.asList(
            new LottoNumber(1),
            new LottoNumber(2),
            new LottoNumber(3),
            new LottoNumber(4),
            new LottoNumber(5),
            new LottoNumber(6)
    ));
    private WinningLotto winningLotto = new WinningLotto(lotto, new LottoNumber(10));

    @ParameterizedTest
    @MethodSource("lottoCompare")
    void 로또번호일치(List<LottoNumber> lottoNumbers, Result result) {
        assertThat(winningLotto.compare(new Lotto(lottoNumbers))).isEqualTo(result);
    }

    static Stream<Arguments> lottoCompare() {
        return Stream.of(
                arguments(Arrays.asList(
                        new LottoNumber(5),
                        new LottoNumber(6),
                        new LottoNumber(7),
                        new LottoNumber(8),
                        new LottoNumber(9),
                        new LottoNumber(10)
                ), Result.UNDERTHREE),
                arguments(Arrays.asList(
                        new LottoNumber(4),
                        new LottoNumber(5),
                        new LottoNumber(6),
                        new LottoNumber(7),
                        new LottoNumber(8),
                        new LottoNumber(9)
                ), Result.THREE),
                arguments(Arrays.asList(
                        new LottoNumber(3),
                        new LottoNumber(4),
                        new LottoNumber(5),
                        new LottoNumber(6),
                        new LottoNumber(7),
                        new LottoNumber(8)
                ), Result.FOUR),
                arguments(Arrays.asList(
                        new LottoNumber(2),
                        new LottoNumber(3),
                        new LottoNumber(4),
                        new LottoNumber(5),
                        new LottoNumber(6),
                        new LottoNumber(9)
                ), Result.FIVE),
                arguments(Arrays.asList(
                        new LottoNumber(2),
                        new LottoNumber(3),
                        new LottoNumber(4),
                        new LottoNumber(5),
                        new LottoNumber(6),
                        new LottoNumber(10)
                ), Result.BONUSFIVE),
                arguments(Arrays.asList(
                        new LottoNumber(1),
                        new LottoNumber(2),
                        new LottoNumber(3),
                        new LottoNumber(4),
                        new LottoNumber(5),
                        new LottoNumber(6)
                ), Result.SIX)
        );
    }

    @Test
    void create() {
        assertThat(winningLotto).isEqualTo(new WinningLotto(lotto, new LottoNumber(10)));
    }
}
