package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class WinningInfoTest {

    private static LottoTickets tickets;

    @BeforeEach
    public void setUp() {
        Lotto ticket = Lotto.ofIntegerNumber(Arrays.asList(1, 2, 3, 4, 5, 6));
        tickets = new LottoTickets(Arrays.asList(ticket));
    }

    @Test
    @DisplayName("구입 티켓과 당첨 티켓의 번호가 3개가 일치하면 FIFTH 카운트가 1 이여야 한다.")
    public void isFIFTH() {
        Lotto winning = Lotto.ofIntegerNumber(Arrays.asList(1, 2, 3, 8, 9, 10));
        LottoWinningNumber winningNumber = new LottoWinningNumber(winning, new LottoNumber(11));
        WinningInfo winningInfo = new WinningInfo(tickets, winningNumber);
        Assertions.assertThat(winningInfo.getWinningInfo().get(Rank.FIFTH)).isEqualTo(1);
    }

    @Test
    @DisplayName("구입 티켓과 당첨 티켓의 번호가 4개가 일치하면 FOURTH 카운트가 1 이여야 한다.")
    public void isFOURTH() {
        Lotto winning = Lotto.ofIntegerNumber(Arrays.asList(1, 2, 3, 4, 9, 10));
        LottoWinningNumber winningNumber = new LottoWinningNumber(winning, new LottoNumber(11));
        WinningInfo winningInfo = new WinningInfo(tickets, winningNumber);
        Assertions.assertThat(winningInfo.getWinningInfo().get(Rank.FOURTH)).isEqualTo(1);
    }

    @Test
    @DisplayName("구입 티켓과 당첨 티켓의 번호가 5개가 일치하면 WinningInfo가 THIRD 카운트가 1 이여야 한다.")
    public void isTHIRD() {
        Lotto winning = Lotto.ofIntegerNumber(Arrays.asList(1, 2, 3, 4, 5, 10));
        LottoWinningNumber winningNumber = new LottoWinningNumber(winning, new LottoNumber(11));
        WinningInfo winningInfo = new WinningInfo(tickets, winningNumber);
        Assertions.assertThat(winningInfo.getWinningInfo().get(Rank.THIRD)).isEqualTo(1);
    }

    @Test
    @DisplayName("구입 티켓과 당첨 티켓의 번호가 5개가 일치하고 보너스가 일치하면 SECOND 카운트가 1 이여야 한다.")
    public void isSECOUND() {
        Lotto winning = Lotto.ofIntegerNumber(Arrays.asList(1, 2, 3, 4, 5, 10));
        LottoWinningNumber winningNumber = new LottoWinningNumber(winning, new LottoNumber(6));
        WinningInfo winningInfo = new WinningInfo(tickets, winningNumber);
        Assertions.assertThat(winningInfo.getWinningInfo().get(Rank.SECOND)).isEqualTo(1);
    }

    @Test
    @DisplayName("구입 티켓과 당첨 티켓의 번호가 6개가 일치하면 WinningInfo가 FIRST 카운트가 1 이여야 한다.")
    public void isFIRST() {
        Lotto winning = Lotto.ofIntegerNumber(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoWinningNumber winningNumber = new LottoWinningNumber(winning, new LottoNumber(11));
        WinningInfo winningInfo = new WinningInfo(tickets, winningNumber);
        Assertions.assertThat(winningInfo.getWinningInfo().get(Rank.FIRST)).isEqualTo(1);
    }
}
