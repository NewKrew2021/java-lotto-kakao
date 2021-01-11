package lotto.domain;

import lotto.utils.Result;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class LottoResultsTest {
    private LottoResults lottoResults;

    @BeforeEach
    void setUp() {
        lottoResults = new LottoResults(Arrays.asList(
                Result.THREE,
                Result.THREE,
                Result.FOUR,
                Result.SIX,
                Result.FIVE
        ));
    }

    @Test
    void testGetReward() {
        assertThat(lottoResults.getReward()).isEqualTo(2001560000L);
    }

    @ParameterizedTest
    @MethodSource("resultCountProvider")
    void testGetResultCount(Result result, int count) {
        assertThat(lottoResults.getResultCount(result)).isEqualTo(count);
    }

    static Stream<Arguments> resultCountProvider() {
        return Stream.of(
                arguments(Result.THREE, 2),
                arguments(Result.FOUR, 1),
                arguments(Result.BONUSFIVE, 0),
                arguments(Result.SIX, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("resultProvider")
    void testResult(int count, boolean bonus, Result result) {
        assertThat(LottoResults.mapResult(count, bonus)).isEqualTo(result);
    }

    static Stream<Arguments> resultProvider() {
        return Stream.of(
                arguments(2, false, Result.UNDERTHREE),
                arguments(3, false, Result.THREE),
                arguments(4, false, Result.FOUR),
                arguments(4, true, Result.FOUR),
                arguments(5, false, Result.FIVE),
                arguments(5, true, Result.BONUSFIVE),
                arguments(6, false, Result.SIX),
                arguments(6, true, Result.SIX)
        );
    }
}
