package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.*;

//import static org.assertj.core.api.Assertions.assertThat;

import static org.assertj.core.api.Assertions.*;

public class LottoTicketsTest {

    @Test
    public void testCreate() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            List<LottoNumbers> tickets = new ArrayList<>();
            Set<Integer> lottoNumbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
            tickets.add(new LottoNumbers(lottoNumbers));
            new LottoTickets(2, tickets);
        });
    }

    @Test
    public void testCalculateLottoStatistics() {
        WinnerNumbers winner = new WinnerNumbers(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)), 10);
        List<LottoNumbers> tickets = new ArrayList<>();
        tickets.add(new LottoNumbers(new HashSet<>(Arrays.asList(1, 2, 7, 8, 9, 11))));
        tickets.add(new LottoNumbers(new HashSet<>(Arrays.asList(1, 2, 3, 7, 8, 9))));//5등
        tickets.add(new LottoNumbers(new HashSet<>(Arrays.asList(1, 2, 3, 4, 7, 8))));//4등
        tickets.add(new LottoNumbers(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 7))));//3등
        tickets.add(new LottoNumbers(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 10))));//2등
        tickets.add(new LottoNumbers(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6))));//1등
        LottoTickets lottoTickets = new LottoTickets(6, tickets);

        Map<Ranking, Integer> statistics = new EnumMap<>(Ranking.class);
        for (Ranking value : Ranking.values()) {
            statistics.put(value, 1);
        }

        assertThat(lottoTickets.calculateLottoStatistics(winner)
                .equals(statistics)).isTrue();
    }


}


