package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketsTest {

    private static LottoTickets tickets;

    @BeforeEach
    public void setUp(){
        Lotto ticket = Lotto.ofIntegerNumber(Arrays.asList(1,2,3,4,5,6));
        tickets = new LottoTickets(Arrays.asList(ticket));
    }

    @Test
    @DisplayName("LottoTickets 객체 생성 테스트")
    public void create(){
        Lotto ticket1 = Lotto.ofIntegerNumber(Arrays.asList(1,2,3,4,5,6));
        Lotto ticket2 = Lotto.ofIntegerNumber(Arrays.asList(1,2,3,4,5,7));
        Lotto ticket3 = Lotto.ofIntegerNumber(Arrays.asList(1,2,3,4,5,8));
        LottoTickets tickets = new LottoTickets(Arrays.asList(ticket1, ticket2, ticket3));
        assertThat(tickets.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("구입 티켓과 당첨 티켓의 번호가 3개가 일치하면 WinningInfo가 1,0,0,0,0 이여야 한다.")
    public void isMatch3(){
        Lotto winning = Lotto.ofIntegerNumber(Arrays.asList(1,2,3,8,9,10));
        LottoWinningNumber winningNumber = new LottoWinningNumber(winning, new LottoNumber(11));
        assertThat(tickets.getWinningInfo(winningNumber))
                .isEqualTo(new WinningInfo(Arrays.asList(1,0,0,0,0)));
    }

    @Test
    @DisplayName("구입 티켓과 당첨 티켓의 번호가 4개가 일치하면 WinningInfo가 0,1,0,0,0 이여야 한다.")
    public void isMatch4(){
        Lotto winning = Lotto.ofIntegerNumber(Arrays.asList(1,2,3,4,9,10));
        LottoWinningNumber winningNumber = new LottoWinningNumber(winning, new LottoNumber(11));
        assertThat(tickets.getWinningInfo(winningNumber))
                .isEqualTo(new WinningInfo(Arrays.asList(0,1,0,0,0)));
    }

    @Test
    @DisplayName("구입 티켓과 당첨 티켓의 번호가 5개가 일치하면 WinningInfo가 0,0,1,0,0 이여야 한다.")
    public void isMatch5(){
        Lotto winning = Lotto.ofIntegerNumber(Arrays.asList(1,2,3,4,5,10));
        LottoWinningNumber winningNumber = new LottoWinningNumber(winning, new LottoNumber(11));
        assertThat(tickets.getWinningInfo(winningNumber))
                .isEqualTo(new WinningInfo(Arrays.asList(0,0,1,0,0)));
    }

    @Test
    @DisplayName("구입 티켓과 당첨 티켓의 번호가 5개가 일치하고 보너스가 일치하면 WinningInfo가 0,0,0,1,0 이여야 한다.")
    public void isMatch5AndBounus(){
        Lotto winning = Lotto.ofIntegerNumber(Arrays.asList(1,2,3,4,5,10));
        LottoWinningNumber winningNumber = new LottoWinningNumber(winning, new LottoNumber(6));
        assertThat(tickets.getWinningInfo(winningNumber))
                .isEqualTo(new WinningInfo(Arrays.asList(0,0,0,1,0)));
    }

    @Test
    @DisplayName("구입 티켓과 당첨 티켓의 번호가 6개가 일치하면 WinningInfo가 0,0,0,0,1 이여야 한다.")
    public void isMatch6(){
        Lotto winning = Lotto.ofIntegerNumber(Arrays.asList(1,2,3,4,5,6));
        LottoWinningNumber winningNumber = new LottoWinningNumber(winning, new LottoNumber(11));
        assertThat(tickets.getWinningInfo(winningNumber))
                .isEqualTo(new WinningInfo(Arrays.asList(0,0,0,0,1)));
    }

}
