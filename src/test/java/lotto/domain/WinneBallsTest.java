package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

public class WinneBallsTest {

    WinnerBalls testWinnerBalls;
    Ticket testTicket;
    int testBonusBall;

    @BeforeEach
    public void setUp(){
        testTicket = new Ticket(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        testBonusBall = 7;
        testWinnerBalls = new WinnerBalls(testTicket, testBonusBall);
    }

    @Test
    public void getTicketTest(){
        assertThat(testWinnerBalls.getTicket()).isEqualTo(testTicket);
    }

    @Test
    public void getBonusBallTest(){
        assertThat(testWinnerBalls.getBonusBall()).isEqualTo(testBonusBall);
    }
}
