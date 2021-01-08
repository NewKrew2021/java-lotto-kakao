package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketsTest {

    @Test
    @DisplayName("LottoTickets 객체 생성 테스트")
    public void create(){
        LottoTicket ticket1 = LottoTicket.ofIntegerNumber(Arrays.asList(1,2,3,4,5,6));
        LottoTicket ticket2 = LottoTicket.ofIntegerNumber(Arrays.asList(1,2,3,4,5,7));
        LottoTicket ticket3 = LottoTicket.ofIntegerNumber(Arrays.asList(1,2,3,4,5,8));
        LottoTickets tickets = new LottoTickets(Arrays.asList(ticket1, ticket2, ticket3));
        assertThat(tickets.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("구입 티켓과 당첨 티켓의 번호가 3개가 일치하면 WinningInfo가 1,0,0,0,0 이여야 한다.")
    public void isMatch3(){
        LottoTicket ticket = LottoTicket.ofIntegerNumber(Arrays.asList(1,2,3,4,5,6));
        LottoTickets tickets = new LottoTickets(Arrays.asList(ticket));

        LottoTicket winning = LottoTicket.ofIntegerNumber(Arrays.asList(1,2,3,8,9,10));
        LottoWinningNumber winningNumber = new LottoWinningNumber(winning, new LottoNumber(11));
        assertThat(tickets.getWinningInfo(winningNumber))
                .isEqualTo(new WinningInfo(Arrays.asList(1,0,0,0,0)));
    }

    @Test
    @DisplayName("구입 티켓과 당첨 티켓의 번호가 4개가 일치하면 WinningInfo가 0,1,0,0,0 이여야 한다.")
    public void isMatch4(){
        LottoTicket ticket = LottoTicket.ofIntegerNumber(Arrays.asList(1,2,3,4,5,6));
        LottoTickets tickets = new LottoTickets(Arrays.asList(ticket));

        LottoTicket winning = LottoTicket.ofIntegerNumber(Arrays.asList(1,2,3,4,9,10));
        LottoWinningNumber winningNumber = new LottoWinningNumber(winning, new LottoNumber(11));
        assertThat(tickets.getWinningInfo(winningNumber))
                .isEqualTo(new WinningInfo(Arrays.asList(0,1,0,0,0)));
    }

    @Test
    @DisplayName("구입 티켓과 당첨 티켓의 번호가 5개가 일치하면 WinningInfo가 0,0,1,0,0 이여야 한다.")
    public void isMatch5(){
        LottoTicket ticket = LottoTicket.ofIntegerNumber(Arrays.asList(1,2,3,4,5,6));
        LottoTickets tickets = new LottoTickets(Arrays.asList(ticket));

        LottoTicket winning = LottoTicket.ofIntegerNumber(Arrays.asList(1,2,3,4,5,10));
        LottoWinningNumber winningNumber = new LottoWinningNumber(winning, new LottoNumber(11));
        assertThat(tickets.getWinningInfo(winningNumber))
                .isEqualTo(new WinningInfo(Arrays.asList(0,0,1,0,0)));
    }

    @Test
    @DisplayName("구입 티켓과 당첨 티켓의 번호가 5개가 일치하고 보너스가 일치하면 WinningInfo가 0,0,0,1,0 이여야 한다.")
    public void isMatch5AndBounus(){
        LottoTicket ticket = LottoTicket.ofIntegerNumber(Arrays.asList(1,2,3,4,5,6));
        LottoTickets tickets = new LottoTickets(Arrays.asList(ticket));

        LottoTicket winning = LottoTicket.ofIntegerNumber(Arrays.asList(1,2,3,4,5,10));
        LottoWinningNumber winningNumber = new LottoWinningNumber(winning, new LottoNumber(6));
        assertThat(tickets.getWinningInfo(winningNumber))
                .isEqualTo(new WinningInfo(Arrays.asList(0,0,0,1,0)));
    }

    @Test
    @DisplayName("구입 티켓과 당첨 티켓의 번호가 6개가 일치하면 WinningInfo가 0,0,0,0,1 이여야 한다.")
    public void isMatch6(){
        LottoTicket ticket = LottoTicket.ofIntegerNumber(Arrays.asList(1,2,3,4,5,6));
        LottoTickets tickets = new LottoTickets(Arrays.asList(ticket));

        LottoTicket winning = LottoTicket.ofIntegerNumber(Arrays.asList(1,2,3,4,5,6));
        LottoWinningNumber winningNumber = new LottoWinningNumber(winning, new LottoNumber(11));
        assertThat(tickets.getWinningInfo(winningNumber))
                .isEqualTo(new WinningInfo(Arrays.asList(0,0,0,0,1)));
    }

}
