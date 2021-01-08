package lotto.domain;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    private Lottos lottos;

    @BeforeEach
    public void setUp() {
        lottos = new Lottos(Arrays.asList(
                new Lotto(() -> Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(() -> Arrays.asList(7, 8, 9, 10, 11, 12))
        ));
    }

    @Test
    public void toStringTest() {
        String expected = "[1, 2, 3, 4, 5, 6]\n"
                + "[7, 8, 9, 10, 11, 12]\n";
        assertThat(lottos.toString()).isEqualTo(expected);
    }

    @Test
    public void raffleTest() {
        Lotto winningNumber = new Lotto(new HashSet(Arrays.asList(LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6))));
        lottos.raffle(winningNumber, LottoNumber.of(6));
        Map<Rank, Integer> expected = new TreeMap<>();
        expected.put(Rank.FIRST, 1);
        assertThat(lottos.raffle(winningNumber, LottoNumber.of(7)).getRank(Rank.FIRST)).isEqualTo(1);
    }

    @Test
    void bonusTest() {
        Lotto w = new Lotto(new HashSet(Arrays.asList(LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(7))));
        Map<Rank,Integer> m = new HashMap<>();
        m.put(Rank.SECOND,1);
        assertThat(lottos.raffle(w, LottoNumber.of(6)).getRank(Rank.SECOND)).isEqualTo(1);
    }
}
