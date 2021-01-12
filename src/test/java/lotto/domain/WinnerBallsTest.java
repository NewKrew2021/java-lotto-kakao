package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerBallsTest {

    private Set<Integer> winningNumbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));

    @DisplayName("valid한 파라미터에 대해 true를 반환하는지 테스트")
    @ParameterizedTest
    @MethodSource("provideWinningNumbersAndBonusBallForTrue")
    public void isValidTestForTrue(List<Integer> winningNumbers, int bonusBall) {
        assertThat(WinnerBalls.isValid(winningNumbers, bonusBall)).isTrue();
    }

    private static Stream<Arguments> provideWinningNumbersAndBonusBallForTrue() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 43, 44, 45), 4),
                Arguments.of(Arrays.asList(1, 2, 3, 43, 44, 45), 5),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 45),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 44)
        );
    }

    @DisplayName("invalid한 파라미터에 대해 false를 반환하는지 테스트")
    @ParameterizedTest
    @MethodSource("provideWinningNumbersAndBonusBallForFalse")
    public void isValidTestForFalse(List<Integer> winningNumbers, int bonusBall) {
        assertThat(WinnerBalls.isValid(winningNumbers, bonusBall)).isFalse();
    }

    private static Stream<Arguments> provideWinningNumbersAndBonusBallForFalse() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6, 7), 8),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6, 6), 8),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5), 6),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 6),
                Arguments.of(Arrays.asList(1, 2, 0, 4, 5, 6), 7),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 46), 7),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 0),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 46)
        );
    }
}