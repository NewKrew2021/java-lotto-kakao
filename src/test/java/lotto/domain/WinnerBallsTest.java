package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinnerBallsTest {

    @DisplayName("정상적인 정보가 주어졌을때, 예외없이 객체를 생성하는지 테스트")
    @ParameterizedTest
    @MethodSource("provideWinningNumbersAndBonusBallForTrue")
    public void createTestForTrue(List<Integer> winningNumbers, int bonusBall) {
        Assertions.assertThatCode(() ->
                new WinnerBalls(winningNumbers, bonusBall)
        ).doesNotThrowAnyException();
    }

    private static Stream<Arguments> provideWinningNumbersAndBonusBallForTrue() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 43, 44, 45), 4),
                Arguments.of(Arrays.asList(1, 2, 3, 43, 44, 45), 5),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 45),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 44)
        );
    }

    @DisplayName("비정상적인 정보가 주어졌을때, 예외를 생성하는지 테스트")
    @ParameterizedTest
    @MethodSource("provideWinningNumbersAndBonusBallForFalse")
    public void isValidTestForFalse(List<Integer> winningNumbers, int bonusBall) {
        assertThatThrownBy(() ->
                new WinnerBalls(winningNumbers, bonusBall)
        ).isInstanceOf(BadWinnerBallsException.class);
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

    @DisplayName("구입한 티켓과 비교하여 Rank를 반환하는 기능 테스트")
    @ParameterizedTest
    @MethodSource("provideTicketInformationAndRanks")
    public void 주어진_티켓의_rank를_계산해주는_기능_테스트(List<Integer> ticketInfo, Rank expectedRank) {
        //given
        WinnerBalls testWinnerBalls = new WinnerBalls(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        Ticket testTicket = new Ticket(new ManuallyGeneratingStrategy(Arrays.asList(new HashSet<>(ticketInfo))));

        //when
        Rank testRank = testWinnerBalls.getRankOf(testTicket);

        //then
        assertThat(testRank).isEqualTo(expectedRank);
    }

    private static Stream<Arguments> provideTicketInformationAndRanks() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), Rank.FIRST),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 7), Rank.SECOND),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 11), Rank.THIRD),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 11, 12), Rank.FOURTH),
                Arguments.of(Arrays.asList(1, 2, 3, 11, 12, 13), Rank.FIFTH),
                Arguments.of(Arrays.asList(1, 2, 11, 12, 13, 14), Rank.OUT)
        );
    }
}