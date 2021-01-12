package lotto.domain.ranking;

import lotto.domain.game.WinnerTicket;
import lotto.domain.number.LottoNumbers;
import lotto.domain.number.ManualInputStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoRankingCountTest {

    private WinnerTicket winnerTicket;
    private List<LottoNumbers> lottoTickets;

    @BeforeEach
    void beforeStart() {

        winnerTicket = WinnerTicket.of(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        lottoTickets = Arrays.asList(
                LottoNumbers.from(new ManualInputStrategy(Arrays.asList(3, 4, 5, 10, 8, 9))),
                LottoNumbers.from(new ManualInputStrategy(Arrays.asList(3, 6, 10, 1, 2, 7))),
                LottoNumbers.from(new ManualInputStrategy(Arrays.asList(12, 4, 5, 6, 1, 2))),
                LottoNumbers.from(new ManualInputStrategy(Arrays.asList(1, 2, 3, 4, 5, 6)))
        );
    }

    @DisplayName("당첨 티켓과 로또에 참여한 게임 숫자들 배열이 주어지면 그에 따른 당첨 등수 개수를 반환한다.")
    @Test
    void create() {
        //when
        LottoRankingCount lottoRankingCount = LottoRankingCount.of(lottoTickets, winnerTicket);

        //then
        Map<LottoRanking, Integer> expected = new HashMap<>();
        expected.put(LottoRanking.RANK_1, 1);
        expected.put(LottoRanking.RANK_2, 0);
        expected.put(LottoRanking.RANK_3, 1);
        expected.put(LottoRanking.RANK_4, 1);
        expected.put(LottoRanking.RANK_5, 1);
        expected.put(LottoRanking.NOTHING, 0);

        assertThat(lottoRankingCount.getRankingCount()).isEqualTo(expected);

    }

    @DisplayName("당첨 티켓과 로또에 참여한 게임 숫자들 배열이 주어지면 그에 따른 총 당첨금액을 구한다.")
    @Test
    void calculateTotalPrice() {
        //when
        LottoRankingCount lottoRankingCount = LottoRankingCount.of(lottoTickets, winnerTicket);

        //then
        long expected = 2_001_555_000L;
        assertThat(lottoRankingCount.calculateTotalPrice()).isEqualTo(expected);
    }

}
