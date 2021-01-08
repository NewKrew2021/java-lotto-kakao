package lotto.domain.game;

import lotto.domain.number.LottoNumbers;
import lotto.domain.ranking.LottoStatistics;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoRevenueTest {
    @DisplayName("당첨 통계 주어지면 그에 따른 총 수익을 구한다.")
    @Test
    void create() {
        //given
        WinnerTicket winnerTicket = WinnerTicket.of(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        List<LottoNumbers> lottoTickets = Arrays.asList(
                LottoNumbers.from(() -> Arrays.asList(2, 3, 4, 5, 6, 7)),
                LottoNumbers.from(() -> Arrays.asList(2, 3, 4, 5, 6, 8)),
                LottoNumbers.from(() -> Arrays.asList(3, 4, 5, 10, 8, 9)),
                LottoNumbers.from(() -> Arrays.asList(10, 13, 44, 35, 6, 8)),
                LottoNumbers.from(() -> Arrays.asList(10, 13, 44, 35, 3, 9))
        );
        LottoStatistics statistics = LottoStatistics.of(lottoTickets, winnerTicket);

        //when
        LottoRevenue lottoRevenue = LottoRevenue.from(statistics);

        //then
        assertThat(lottoRevenue.getRevenue()).isEqualTo(31505000L);
    }


}
