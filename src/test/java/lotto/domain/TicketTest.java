package lotto.domain;

import lotto.exceptions.BadTicketException;
import lotto.domain.strategies.ManuallyGeneratingStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("TicketTest class")
public class TicketTest {
    Ticket testTicket = new Ticket(
            new ManuallyGeneratingStrategy(
                    Arrays.asList(
                            new HashSet<>(Arrays.asList(1, 2, 10, 30, 44, 45))
                    )
            )
    );

    @DisplayName("잘못된 티켓 정보가 전달되었을때 예외가 발생하는지 체크")
    @ParameterizedTest
    @MethodSource("provideAbnormalTicketValue")
    public void createAbnormal(Set<Integer> abnormalValue) {
        assertThatThrownBy(() ->
                new Ticket(
                        new ManuallyGeneratingStrategy(
                                Arrays.asList(abnormalValue)
                        )
                )
        ).isInstanceOf(BadTicketException.class);
    }

    private static Stream<Arguments> provideAbnormalTicketValue() {
        return Stream.of(
                Arguments.of(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7))),
                Arguments.of(new HashSet<>(Arrays.asList(1, 2, 46, 4, 5, 6))),
                Arguments.of(new HashSet<>(Arrays.asList(1, 0, 3, 4, 5, 6)))
        );
    }

    @DisplayName("isConstains 메서드가 정상 작동하는 지 확인")
    @ParameterizedTest
    @MethodSource("provideInputBallAndResult")
    public void isContainsTest(int testBall, boolean result) {
        assertThat(testTicket.isContain(testBall)).isEqualTo(result);
    }

    private static Stream<Arguments> provideInputBallAndResult() {
        return Stream.of(
                Arguments.of(1, true),
                Arguments.of(2, true),
                Arguments.of(45, true),
                Arguments.of(3, false)
        );
    }

    @DisplayName("Ticket 객체의 값을 가져오는 것을 테스트")
    @Test
    public void getNumberDataTest() {
        assertThat(testTicket.getNumberData()).isEqualTo(
                new HashSet<Integer>(
                        Arrays.asList( 1, 2, 10, 30, 44, 45 )
                )
        );
    }
}