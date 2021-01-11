package lotto.domain;

import lotto.domain.vo.LottoNumber;
import lotto.domain.vo.Rate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoStatisticsTest {
    private LottoNumbers luckyNumbers;
    private LottoNumber bonusNumber;
    private WinningNumbers winningNumbers;
    private LottoMatcher matcher;
    private int investedMoney;

    @BeforeEach
    void setUp() {
        luckyNumbers = new LottoNumbers(LottoNumberArray.asList(1, 2, 3, 4, 5, 6));
        bonusNumber = LottoNumber.valueOf(7);
        winningNumbers = new WinningNumbers(luckyNumbers, bonusNumber);
        matcher = new LottoMatcher(winningNumbers);
        investedMoney = 3000;
    }

    @Test
    void firstSecondFifthMatchStatistics() {
        LottoNumbers firstPlace = new LottoNumbers(LottoNumberArray.asList(1, 2, 3, 4, 5, 6));
        LottoNumbers secondPlace = new LottoNumbers(LottoNumberArray.asList(1, 2, 3, 4, 5, 7));
        LottoNumbers fifthPlace = new LottoNumbers(LottoNumberArray.asList(1, 2, 3, 8, 9, 10));
        LottoTickets tickets = new LottoTickets(
                Arrays.asList(
                        firstPlace,
                        secondPlace,
                        fifthPlace
                ));

        LottoStatistics statistics = new LottoStatistics(matcher.match(tickets), investedMoney);
        MatchResults expectedMatches = new MatchResults(Arrays.asList(
                MatchResult.FIRST,
                MatchResult.SECOND,
                MatchResult.FIFTH
        ));
        double expectedRateInRealNumber = (double) ((long) MatchResult.FIRST.getReward()
                + MatchResult.SECOND.getReward() + MatchResult.FIFTH.getReward()) / investedMoney;
        Rate expectedRate = new Rate((int) (Math.round(expectedRateInRealNumber * 100)));

        assertThat(statistics.getResults()).isEqualTo(expectedMatches.getResult());
        assertThat(statistics.getEarningRate()).isEqualTo(expectedRate);
    }
}
