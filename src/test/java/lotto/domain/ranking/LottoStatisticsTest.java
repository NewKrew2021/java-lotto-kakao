package lotto.domain.ranking;

import lotto.domain.game.WinnerTicket;
import lotto.domain.number.LottoNumbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStatisticsTest {

    private WinnerTicket winnerTicket;
    private List<LottoNumbers> lottoTickets;

    @BeforeEach
    void setUp() {
        winnerTicket = WinnerTicket.of(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        lottoTickets = Arrays.asList(
                LottoNumbers.from(Arrays.asList(2, 3, 4, 5, 6, 7)),
                LottoNumbers.from(Arrays.asList(2, 3, 4, 5, 6, 8)),
                LottoNumbers.from(Arrays.asList(3, 4, 5, 10, 8, 9)),
                LottoNumbers.from(Arrays.asList(10, 13, 44, 35, 6, 8)),
                LottoNumbers.from(Arrays.asList(10, 13, 44, 35, 3, 9))
        );
    }

    @DisplayName("당첨 티켓과 로또 티켓들이 주어지면 알맞은 통계가 생성된다.")
    @Test
    void create() {
        //when
        LottoStatistics lottoStatistics = LottoStatistics.of(lottoTickets, winnerTicket);

        //then
        Map<LottoRanking, Long> expected = new HashMap<>();
        expected.put(LottoRanking.RANK_1, 0L);
        expected.put(LottoRanking.RANK_2, 1L);
        expected.put(LottoRanking.RANK_3, 1L);
        expected.put(LottoRanking.RANK_4, 0L);
        expected.put(LottoRanking.RANK_5, 1L);
        expected.put(LottoRanking.NOTHING, 2L);
        assertThat(lottoStatistics.getRankingCount()).isEqualTo(expected);
    }

    @DisplayName("통계가 주어지면 당첨금액의 합을 구한다.")
    @Test
    void totalMoney() {
        //given
        LottoStatistics lottoStatistics = LottoStatistics.of(lottoTickets, winnerTicket);

        //when
        long result = lottoStatistics.calculateTotalPrice();

        //then
        assertThat(result).isEqualTo(31505000L);
    }
}