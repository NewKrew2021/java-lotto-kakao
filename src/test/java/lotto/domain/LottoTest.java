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
        assertThatThrownBy(() -> Lotto.of("1, 1, 2, 3, 4, 5")).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @MethodSource("invalidArguments")
    void testInvalidArguments(String lottoNumbers) {
        assertThatThrownBy(() -> Lotto.of(lottoNumbers)).isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> invalidArguments() {
        return Stream.of(
                arguments("1, 5, 45, 2, 3, 7, 9"),
                arguments("1, 5, 45, 2, 3")
        );
    }

    @Test
    void testSort() {
        Lotto lotto = Lotto.of("1, 2, 3, 4, 5, 6");
        assertThat(lotto).isEqualTo(Lotto.of("3, 1, 4, 5, 2, 6"));
    }

    @Test
    void testCreate() {
        Lotto lotto = Lotto.of("1, 2, 3, 4, 5, 6");
        assertThat(lotto).isEqualTo(Lotto.of("1, 2, 3, 4, 5, 6"));
    }
}
