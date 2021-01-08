package lotto.domain;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class TicketTest {

    @Test
    public void sizeCheckTest(){
        Set<Integer> testNumbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7));

        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> {
                    new Ticket(testNumbers);
                }).withMessageMatching("invalid Ticket size!!");
    }

    @Test
    public void invalidNumberCheckTest(){
        Set<Integer> testNumbers = new HashSet<>(Arrays.asList(0, 20, 30, 40, 43, 44));

        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> {
                    new Ticket(testNumbers);
                }).withMessageMatching("contains invalid number value.");
    }

    @Test
    public void isContains_test_1(){
        Set<Integer> testNumbers = new HashSet<>(Arrays.asList(1, 2, 10, 30, 44, 45));
        Ticket curTicket = new Ticket(testNumbers);
        assertThat(curTicket.isContain(45)).isEqualTo(true);
    }

    @Test
    public void isContains_test_2(){
        Set<Integer> testNumbers = new HashSet<>(Arrays.asList(1, 2, 10, 30, 44, 45));
        Ticket curTicket = new Ticket(testNumbers);
        assertThat(curTicket.isContain(3)).isEqualTo(false);
    }

    @Test
    public void GetOrder_test_1(){
        Set<Integer> numbersForUser = new HashSet<>(Arrays.asList(1, 2, 10, 30, 44, 45));
        Set<Integer> numbersForWinner = new HashSet<>(Arrays.asList(1, 2, 10, 30, 44, 45));
        int bonusBall = 7;

        Ticket userTicket = new Ticket(numbersForUser);
        WinnerBalls winnerBalls = new WinnerBalls(new Ticket(numbersForWinner), bonusBall);

        assertThat(userTicket.getOrder(winnerBalls)).isEqualTo(1);   //TODO : 몇등인지에 대한 정보를 enum으로 나타내기
    }

    @Test
    public void GetOrder_test_2(){
        Set<Integer> numbersForUser = new HashSet<>(Arrays.asList(7, 2, 10, 30, 44, 45));
        Set<Integer> numbersForWinner = new HashSet<>(Arrays.asList(1, 2, 10, 30, 44, 45));
        int bonusBall = 7;

        Ticket userTicket = new Ticket(numbersForUser);
        WinnerBalls winnerBalls = new WinnerBalls(new Ticket(numbersForWinner), bonusBall);

        assertThat(userTicket.getOrder(winnerBalls)).isEqualTo(2);
    }

    @Test
    public void GetOrder_test_3(){
        Set<Integer> numbersForUser = new HashSet<>(Arrays.asList(8, 2, 10, 30, 44, 45));
        Set<Integer> numbersForWinner = new HashSet<>(Arrays.asList(1, 2, 10, 30, 44, 45));
        int bonusBall = 7;

        Ticket userTicket = new Ticket(numbersForUser);
        WinnerBalls winnerBalls = new WinnerBalls(new Ticket(numbersForWinner), bonusBall);

        assertThat(userTicket.getOrder(winnerBalls)).isEqualTo(3);
    }

    @Test
    public void GetOrder_test_4(){
        Set<Integer> numbersForUser = new HashSet<>(Arrays.asList(11, 12, 30, 31, 32, 45));
        Set<Integer> numbersForWinner = new HashSet<>(Arrays.asList(1, 2, 30, 31, 32, 45));
        int bonusBall = 7;

        Ticket userTicket = new Ticket(numbersForUser);
        WinnerBalls winnerBalls = new WinnerBalls(new Ticket(numbersForWinner), bonusBall);

        assertThat(userTicket.getOrder(winnerBalls)).isEqualTo(4);
    }

    @Test
    public void GetOrder_test_5(){
        Set<Integer> numbersForUser = new HashSet<>(Arrays.asList(11, 12, 13, 40, 41, 45));
        Set<Integer> numbersForWinner = new HashSet<>(Arrays.asList(1, 2, 3, 40, 41, 45));
        int bonusBall = 7;

        Ticket userTicket = new Ticket(numbersForUser);
        WinnerBalls winnerBalls = new WinnerBalls(new Ticket(numbersForWinner), bonusBall);

        assertThat(userTicket.getOrder(winnerBalls)).isEqualTo(5);
    }

    @Test
    public void GetOrder_test_6(){
        Set<Integer> numbersForUser = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        Set<Integer> numbersForWinner = new HashSet<>(Arrays.asList(7, 8, 9, 10, 11, 12));
        int bonusBall = 13;

        Ticket userTicket = new Ticket(numbersForUser);
        WinnerBalls winnerBalls = new WinnerBalls(new Ticket(numbersForWinner), bonusBall);

        assertThat(userTicket.getOrder(winnerBalls)).isEqualTo(6);
    }
}
