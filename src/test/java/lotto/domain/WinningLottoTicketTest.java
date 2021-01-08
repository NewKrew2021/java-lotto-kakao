package lotto.domain;

import lotto.StatisticsType;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.*;

public class WinningLottoTicketTest {

    @Test
    void bonusNoTest() {
        assertThatThrownBy(() ->
                new WinningLottoNos(Arrays.asList(1, 2, 3, 4, 5, 6), 3)
        ).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() ->
            new WinningLottoNos(Arrays.asList(1, 2, 3, 4, 5, 6), 0)
        ).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() ->
            new WinningLottoNos(Arrays.asList(1, 2, 3, 4, 5, 6), 46)
        ).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() ->
            new WinningLottoNos(Arrays.asList(1, 2, 3, 3, 5, 5), 0)
        ).isInstanceOf(IllegalArgumentException.class);

        WinningLottoNos winningLottoNos = new WinningLottoNos(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
    }

    @Test
    void isWinningTest() {
        WinningLottoNos winningLottoNos = new WinningLottoNos(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        LottoTicket lottoTicket2 = new LottoTicket(Arrays.asList(1, 2, 9, 10, 11, 12)); // 2
        LottoTicket lottoTicket3 = new LottoTicket(Arrays.asList(1, 2, 3, 9, 10, 11)); // 3
        LottoTicket lottoTicket4 = new LottoTicket(Arrays.asList(1, 2, 3, 4, 10, 11)); // 4
        LottoTicket lottoTicket5 = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 8)); // 5
        LottoTicket lottoTicket5_1 = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 7)); // 5,1
        LottoTicket lottoTicket6 = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6)); // 6

        assertThat(winningLottoNos.isWinning(lottoTicket2))
                .isEqualTo(StatisticsType.NONE);
        assertThat(winningLottoNos.isWinning(lottoTicket3))
                .isEqualTo(StatisticsType.THREE);
        assertThat(winningLottoNos.isWinning(lottoTicket4))
                .isEqualTo(StatisticsType.FOUR);
        assertThat(winningLottoNos.isWinning(lottoTicket5))
                .isEqualTo(StatisticsType.FIVE);
        assertThat(winningLottoNos.isWinning(lottoTicket5_1))
                .isEqualTo(StatisticsType.FIVE_WITH_BONUS);
        assertThat(winningLottoNos.isWinning(lottoTicket6))
                .isEqualTo(StatisticsType.SIX);
    }

}
