package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.shadow.com.univocity.parsers.common.ArgumentUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("TicketTest class")
public class TicketTest {
    Ticket testTicket = new Ticket(
            new ManuallyGeneratingStrategy(
                    Arrays.asList(
                            new HashSet<>(Arrays.asList(1, 2, 10, 30, 44, 45))
                    )
            )
    );

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