package lotto.domain;

import lotto.domain.dto.InsertPrice;
import lotto.domain.dto.LottoNumber;
import lotto.domain.dto.Rate;
import lotto.domain.dto.WinningNumbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class LottoStatisticsTest {
    private LottoNumbers luckyNumbers;
    private LottoNumber bonusNumber;
    private WinningNumbers winningNumbers;
    private LottoMatcher matcher;
    private int investedMoney;

    @BeforeEach
    void setUp() {
        luckyNumbers = new LottoNumbers(Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::new)
                .collect(Collectors.toList()));
        bonusNumber = new LottoNumber(7);
        winningNumbers = new WinningNumbers(luckyNumbers, bonusNumber);
        matcher = new LottoMatcher(winningNumbers);
        investedMoney = 3000;
    }

    @Test
    void firstSecondFifthMatchStatistics() {
        LottoNumbers firstPlace = new LottoNumbers(customLottoNumbers(1, 2, 3, 4, 5, 6));
        LottoNumbers secondPlace = new LottoNumbers(customLottoNumbers(1, 2, 3, 4, 5, 7));
        LottoNumbers fifthPlace = new LottoNumbers(customLottoNumbers(1, 2, 3, 8, 9, 10));
        LottoTickets tickets = new LottoTickets(
                Arrays.asList(
                        firstPlace,
                        secondPlace,
                        fifthPlace
                ));

        LottoStatistics statistics = new LottoStatistics(matcher.match(tickets), investedMoney);
        StatisticsResult statisticsResult = statistics.getStatisticsResult();
        double expectedRateInRealNumber = (double) ((long) MatchResult.FIRST.getReward()
                + MatchResult.SECOND.getReward() + MatchResult.FIFTH.getReward()) / investedMoney;
        MatchResults expectedMatches = new MatchResults(Arrays.asList(
                MatchResult.FIRST,
                MatchResult.SECOND,
                MatchResult.FIFTH
        ));
        Rate expectedRate = new Rate((int) (Math.round(expectedRateInRealNumber * 100)));

        assertThat(statisticsResult)
                .isEqualTo(new StatisticsResult(expectedMatches, expectedRate));
    }

    private List<LottoNumber> customLottoNumbers(int... parameters) {
        return Arrays.stream(parameters)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }
}
