package mission.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumberTest {

    static Stream<Arguments> numberGenerator() {
        return IntStream.range(Number.MIN_NUMBER_VALUE, Number.MAX_NUMBER_VALUE + 1)
                .mapToObj(Arguments::of);
    }

    static Stream<Arguments> invalidNumberGenerator() {
        return Stream.of(
                Arguments.of(46),
                Arguments.of(0),
                Arguments.of(-1)
        );
    }

    @ParameterizedTest
    @MethodSource("numberGenerator")
    @DisplayName("로또 번호 싱글턴 객체 테스트")
    public void numberSingletonTest(int num) {
        // given
        Number number = Number.of(num);

        // when
        Number number2 = Number.of(num);

        // then
        assertThat(number == number2).isEqualTo(true);
    }

    @ParameterizedTest
    @MethodSource("invalidNumberGenerator")
    public void numberExceptionTest(int num) {
        assertThatThrownBy(() -> Number.of(num))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
