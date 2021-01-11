package lotto.domain;

import lotto.domain.dto.LottoNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMatcherTest {
    private List<LottoNumber> answer;
    private LottoNumbers luckyNumbers;
    private LottoNumber bonusNumber;
    private WinningNumbers winningNumbers;
    private LottoMatcher matcher;

    @BeforeEach
    void setUp() {
        answer = LottoNumberArray.asList(1, 2, 3, 4, 5, 6);

        luckyNumbers = new LottoNumbers(answer);
        bonusNumber = LottoNumber.valueOf(7);
        winningNumbers = new WinningNumbers(luckyNumbers, bonusNumber);
        matcher = new LottoMatcher(winningNumbers);
    }

    @ParameterizedTest
    @ArgumentsSource(lottoNumberArgumentsProvider.class)
    void testRanks(List<LottoNumber> numbers, MatchResult expected) {
        assertThat(matcher.match(new LottoNumbers(numbers))).isEqualTo(expected);
    }

    @Test
    void matchFirstFifthNullAsTickets() {
        LottoTickets lottoTickets = new LottoTickets(Arrays.asList(
                new LottoNumbers(LottoNumberArray.asList(1, 2, 3, 4, 5, 6)),
                new LottoNumbers(LottoNumberArray.asList(1, 2, 3, 7, 8, 9)),
                new LottoNumbers(LottoNumberArray.asList(1, 2, 8, 9, 10, 11))
        ));

        assertThat(matcher.match(lottoTickets))
                .isEqualTo(new MatchResults(Arrays.asList(
                        MatchResult.FIRST,
                        MatchResult.FIFTH,
                        MatchResult.LOSE
                )));
    }
}

class lottoNumberArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of(
                Arguments.of(LottoNumberArray.asList(1, 2, 3, 4, 5, 6), MatchResult.FIRST),
                Arguments.of(LottoNumberArray.asList(1, 2, 3, 4, 5, 7), MatchResult.SECOND),
                Arguments.of(LottoNumberArray.asList(1, 2, 3, 4, 5, 8), MatchResult.THIRD),
                Arguments.of(LottoNumberArray.asList(1, 2, 3, 4, 8, 9), MatchResult.FOURTH),
                Arguments.of(LottoNumberArray.asList(1, 2, 3, 8, 9, 10), MatchResult.FIFTH),
                Arguments.of(LottoNumberArray.asList(1, 2, 7, 8, 9, 10), MatchResult.LOSE),
                Arguments.of(LottoNumberArray.asList(1, 2, 8, 9, 10, 11), MatchResult.LOSE)
        );
    }
}
