package lotto.domain;

import lotto.utils.Result;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class LottoTest {
    @Test
    void testDuplicate() {
        assertThatThrownBy(() -> new Lotto(Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5)))
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("invalidArguments")
    void testInvalidArguments(List<LottoNumber> lottoNumbers) {
        assertThatThrownBy(() -> new Lotto(lottoNumbers)).isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> invalidArguments() {
        return Stream.of(
                arguments(Arrays.asList(
                        new LottoNumber(1),
                        new LottoNumber(5),
                        new LottoNumber(45),
                        new LottoNumber(2),
                        new LottoNumber(3),
                        new LottoNumber(7),
                        new LottoNumber(9))),
                arguments(Arrays.asList(
                        new LottoNumber(1),
                        new LottoNumber(5),
                        new LottoNumber(45),
                        new LottoNumber(2),
                        new LottoNumber(3)))
        );
    }

    @Test
    void testSort() {
        Lotto lotto = new Lotto(Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        ));
        assertThat(lotto).isEqualTo(new Lotto(Arrays.asList(
                new LottoNumber(3),
                new LottoNumber(1),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(2),
                new LottoNumber(6)
        )));
    }

    @Test
    void create() {
        Lotto lotto = new Lotto(Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        ));
        assertThat(lotto).isEqualTo(new Lotto(Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        )));
    }
}
