package lotto.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("CustomTypeCasting 클래스")
public class CustomTypeCastingTest {

    @DisplayName("전달받은 string을 split한후, 숫자리스트로 반환받는 기능을 테스트")
    @ParameterizedTest()
    @MethodSource("provideStringAndInteger")
    public void stringToIntegersUsingParsing(String testString, List<Integer> integers){
        assertThat(CustomTypeCasting.stringToIntegersUsingParsing(testString, ","))
                .isEqualTo(integers);
    }

    private static Stream<Arguments> provideStringAndInteger(){
        return Stream.of(
                Arguments.of("1, 2, 3, 4, 5, 6", new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6))),
                Arguments.of("1, 2 , 3, 4, 5, 6", new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6))),
                Arguments.of("1, 2,     3, 4, 5, 6", new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6))),
                Arguments.of(" 1, 2, 43 , 4, 5, 6", new ArrayList<>(Arrays.asList(1, 2, 43, 4, 5, 6)))
        );
    }
}
