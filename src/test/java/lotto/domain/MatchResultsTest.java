package lotto.domain;

import lotto.domain.dto.LottoNumber;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MatchResultsTest {
    @Test
    void matchesAreCorrect() {
        LottoNumbers luckyNumbers = new LottoNumbers(LottoNumberArray.asList(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNumber = LottoNumber.valueOf(7);
        WinningNumbers winningNumbers = new WinningNumbers(luckyNumbers, bonusNumber);
        LottoMatcher lottoMatcher = new LottoMatcher(winningNumbers);

        LottoTickets lottoTickets = new LottoTickets(Arrays.asList(
                new LottoNumbers(LottoNumberArray.asList(1, 2, 3, 4, 5, 6)),
                new LottoNumbers(LottoNumberArray.asList(1, 2, 3, 4, 5, 7)),
                new LottoNumbers(LottoNumberArray.asList(1, 2, 3, 4, 5, 8)),
                new LottoNumbers(LottoNumberArray.asList(1, 2, 3, 4, 8, 9)),
                new LottoNumbers(LottoNumberArray.asList(1, 2, 3, 8, 9, 10)),
                new LottoNumbers(LottoNumberArray.asList(1, 2, 3, 7, 8, 9)),
                new LottoNumbers(LottoNumberArray.asList(1, 2, 7, 8, 9, 10)),
                new LottoNumbers(LottoNumberArray.asList(1, 2, 8, 9, 10, 11))));

        assertThat(lottoMatcher.match(lottoTickets))
                .isEqualTo(new MatchResults(Arrays.asList(
                        MatchResult.FIRST,
                        MatchResult.SECOND,
                        MatchResult.THIRD,
                        MatchResult.FOURTH,
                        MatchResult.FIFTH,
                        MatchResult.FIFTH,
                        MatchResult.LOSE,
                        MatchResult.LOSE
                )));
    }

    @Test
    void testGetTotalEarnings() {
        MatchResults matchResults = new MatchResults(Arrays.asList(
                MatchResult.FIRST,
                MatchResult.THIRD
        ));

        assertThat(matchResults.getTotalEarnings())
                .isEqualTo(MatchResult.FIRST.getReward() + MatchResult.THIRD.getReward());
    }

    @Test
    void testHashCode() {
        List<MatchResult> results = Arrays.asList(
                MatchResult.FIRST,
                MatchResult.SECOND
        );
        List<MatchResult> differentResult = Arrays.asList(
                MatchResult.FIRST,
                MatchResult.THIRD
        );
        MatchResults matchResults = new MatchResults(results);

        assertThat(matchResults.hashCode()).isEqualTo(new MatchResults(results).hashCode());
        assertThat(matchResults.hashCode()).isNotEqualTo(new MatchResults(differentResult).hashCode());
    }
}
