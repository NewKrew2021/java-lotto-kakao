package lotto.domain;

import lotto.dto.LottoNumberData;
import lotto.setting.Rank;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoPaperTest {

    @Test
    public void getScoreCompareWith_test_1() {
        LottoPaper paper = new LottoPaper(
                new LottoNumberData(
                        Arrays.asList(
                                new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)),
                                new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 7)),
                                new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 45)),
                                new HashSet<>(Arrays.asList(1, 2, 3, 4, 44, 45)),
                                new HashSet<>(Arrays.asList(1, 2, 3, 43, 44, 45)),
                                new HashSet<>(Arrays.asList(1, 2, 42, 43, 44, 45)),
                                new HashSet<>(Arrays.asList(1, 41, 42, 43, 44, 45)),
                                new HashSet<>(Arrays.asList(40, 41, 42, 43, 44, 45))
                        )
                )
        );

        int bonusBall = 7;
        Set<Integer> numbersForWinner = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinnerBalls winnerBalls = new WinnerBalls(new Ticket(numbersForWinner), bonusBall);

        assertThat(paper.getScoreCompareWith(winnerBalls)).isEqualTo(
                Rank.FIRST.getPrize() + Rank.SECOND.getPrize()
                        + Rank.THIRD.getPrize() + Rank.FOURTH.getPrize()
                        + Rank.FIFTH.getPrize() + Rank.OUT.getPrize()
                        + Rank.OUT.getPrize() + Rank.OUT.getPrize()
        );
    }

    @Test
    public void getScoreCompareWith_test_2() {
        LottoPaper paper = new LottoPaper(
                new LottoNumberData(
                        Arrays.asList(
                                new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)),
                                new HashSet<>(Arrays.asList(7, 8, 9, 10, 11, 12)),
                                new HashSet<>(Arrays.asList(13, 14, 15, 16, 17, 18)),
                                new HashSet<>(Arrays.asList(19, 20, 21, 22, 23, 24)),
                                new HashSet<>(Arrays.asList(25, 26, 27, 28, 29, 30))
                        )
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
                new LottoNumberData(
                        Arrays.asList(
                                new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)),
                                new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)),
                                new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)),
                                new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)),
                                new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)),
                                new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)),
                                new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)),
                                new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)),
                                new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)),
                                new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)),
                                new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)),
                                new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)),
                                new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)),
                                new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)),
                                new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)),
                                new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)),
                                new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)),
                                new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)),
                                new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)),
                                new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)) //20th
                        )
                )
        );

        int bonusBall = 7;
        Set<Integer> numbersForWinner = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinnerBalls winnerBalls = new WinnerBalls(new Ticket(numbersForWinner), bonusBall);

        assertThat(paper.getScoreCompareWith(winnerBalls)).isEqualTo(Rank.FIRST.getPrize() * 20L);
    }
}
