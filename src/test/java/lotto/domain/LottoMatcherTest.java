package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class lottoNumberArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of(
                Arguments.of(lottoNumberArgument(1, 2, 3, 4, 5, 6), MatchResult.FIRST),
                Arguments.of(lottoNumberArgument(1, 2, 3, 4, 5, 7), MatchResult.SECOND),
                Arguments.of(lottoNumberArgument(1, 2, 3, 4, 5, 8), MatchResult.THIRD),
                Arguments.of(lottoNumberArgument(1, 2, 3, 4, 8, 9), MatchResult.FOURTH),
                Arguments.of(lottoNumberArgument(1, 2, 3, 8, 9, 10), MatchResult.FIFTH),
                Arguments.of(lottoNumberArgument(1, 2, 8, 9, 10, 11), MatchResult.NULL)
        );
    }

    private List<LottoNumber> lottoNumberArgument(int... parameters) {
        return Stream.of(parameters[0], parameters[1], parameters[2],
                parameters[3], parameters[4], parameters[5])
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }
}

public class LottoMatcherTest {
    private List<LottoNumber> answer;
    private LottoNumbers luckyNumbers;
    private LottoNumber bonusNumber;
    private WinningNumbers winningNumbers;
    private LottoMatcher matcher;

    @BeforeEach
    void setUp() {
        answer = Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::new)
                .collect(Collectors.toList());

        luckyNumbers = new LottoNumbers(answer);
        bonusNumber = new LottoNumber(7);
        winningNumbers = new WinningNumbers(luckyNumbers, bonusNumber);
        matcher = new LottoMatcher(winningNumbers);
    }

    @ParameterizedTest
    @ArgumentsSource(lottoNumberArgumentsProvider.class)
    void testRanks(List<LottoNumber> numbers, MatchResult expected) {
        assertThat(matcher.match(
                new LottoNumbers(numbers)
        )).isEqualTo(expected);
    }

    @Test
    void matchFirstFifthNullAsTickets() {
        LottoTickets lottoTickets = new LottoTickets(Arrays.asList(
                new LottoNumbers(customLottoNumbers(1, 2, 3, 4, 5, 6)),
                new LottoNumbers(customLottoNumbers(1, 2, 3, 7, 8, 9)),
                new LottoNumbers(customLottoNumbers(1, 2, 8, 9, 10, 11))
        ));

        assertThat(matcher.match(lottoTickets))
                .isEqualTo(new MatchResults(Arrays.asList(
                        MatchResult.FIRST,
                        MatchResult.FIFTH,
                        MatchResult.NULL
                )));
    }

    private List<LottoNumber> customLottoNumbers(int... parameters) {
        return Stream.of(parameters[0], parameters[1], parameters[2],
                parameters[3], parameters[4], parameters[5])
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }
}
