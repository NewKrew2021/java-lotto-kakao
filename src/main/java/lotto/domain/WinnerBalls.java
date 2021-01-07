package lotto.domain;

import java.util.List;

public class WinnerBalls {
    private final Ticket ticket;
    private final int bonusBall;

    public WinnerBalls(Ticket ticket, int bonusBall){
        this.ticket = ticket;
        this.bonusBall = bonusBall;
    }

    public Ticket getTicket(){
        return ticket;
    }

    public int getBonusBall(){
        return bonusBall;
    }
}
