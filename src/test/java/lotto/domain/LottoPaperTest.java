package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoPaperTest {

    @Test
    public void getScoreCompareWith_test_1() {
        LottoPaper paper = new LottoPaper(
                Arrays.asList(
                        Arrays.asList(1, 2, 3, 4, 5, 6),
                        Arrays.asList(1, 2, 3, 4, 5, 7),
                        Arrays.asList(1, 2, 3, 4, 5, 45),
                        Arrays.asList(1, 2, 3, 4, 44, 45),
                        Arrays.asList(1, 2, 3, 43, 44, 45),
                        Arrays.asList(1, 2, 42, 43, 44, 45),
                        Arrays.asList(1, 41, 42, 43, 44, 45),
                        Arrays.asList(40, 41, 42, 43, 44, 45)
                )
        );

        int bonusBall = 7;
        Set<Integer> numbersForWinner = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinnerBalls winnerBalls = new WinnerBalls(new Ticket(numbersForWinner), bonusBall);

        assertThat(paper.getScoreCompareWith(winnerBalls)).isEqualTo(
                2000000000 + 30000000 + 1500000 + 50000 + 5000 + 0 + 0 + 0); //TODO : 상금부분을 enum으로 빼면 좋을듯?
    }

    @Test
    public void getScoreCompareWith_test_2() {
        LottoPaper paper = new LottoPaper(
                Arrays.asList(
                        Arrays.asList(1, 2, 3, 4, 5, 6),
                        Arrays.asList(7, 8, 9, 10, 11, 12),
                        Arrays.asList(13, 14, 15, 16, 17, 18),
                        Arrays.asList(19, 20, 21, 22, 23, 24),
                        Arrays.asList(25, 26, 27, 28, 29, 30)
                )
        );

        int bonusBall = 7;
        Set<Integer> numbersForWinner = new HashSet<>(Arrays.asList(31, 32, 33, 34, 35, 36));
        WinnerBalls winnerBalls = new WinnerBalls(new Ticket(numbersForWinner), bonusBall);

        assertThat(paper.getScoreCompareWith(winnerBalls)).isEqualTo(0);
    }

    @Test
    public void getScoreCompareWith_test_3() {
        LottoPaper paper = new LottoPaper(
                Arrays.asList(
                        Arrays.asList(1, 2, 3, 4, 5, 6),
                        Arrays.asList(1, 2, 3, 4, 5, 6),
                        Arrays.asList(1, 2, 3, 4, 5, 6),
                        Arrays.asList(1, 2, 3, 4, 5, 6),
                        Arrays.asList(1, 2, 3, 4, 5, 6),
                        Arrays.asList(1, 2, 3, 4, 5, 6),
                        Arrays.asList(1, 2, 3, 4, 5, 6),
                        Arrays.asList(1, 2, 3, 4, 5, 6),
                        Arrays.asList(1, 2, 3, 4, 5, 6),
                        Arrays.asList(1, 2, 3, 4, 5, 6),
                        Arrays.asList(1, 2, 3, 4, 5, 6),
                        Arrays.asList(1, 2, 3, 4, 5, 6),
                        Arrays.asList(1, 2, 3, 4, 5, 6),
                        Arrays.asList(1, 2, 3, 4, 5, 6),
                        Arrays.asList(1, 2, 3, 4, 5, 6),
                        Arrays.asList(1, 2, 3, 4, 5, 6),
                        Arrays.asList(1, 2, 3, 4, 5, 6),
                        Arrays.asList(1, 2, 3, 4, 5, 6),
                        Arrays.asList(1, 2, 3, 4, 5, 6),
                        Arrays.asList(1, 2, 3, 4, 5, 6) // 20th
                )
        );

        int bonusBall = 7;
        Set<Integer> numbersForWinner = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinnerBalls winnerBalls = new WinnerBalls(new Ticket(numbersForWinner), bonusBall);

        assertThat(paper.getScoreCompareWith(winnerBalls)).isEqualTo(2000000000L * 20);
    }
}
