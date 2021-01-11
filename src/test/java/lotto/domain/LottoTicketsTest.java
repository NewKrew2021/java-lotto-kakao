package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketsTest {

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
        LottoTickets lottoTickets = new LottoTickets(tickets);

        LottoStatistics statistics = new LottoStatistics();
        for (Ranking value : Ranking.values()) {
            statistics.addValue(value, 1);
        }

        assertThat(lottoTickets.calculateLottoStatistics(winner)
                .equals(statistics)).isTrue();
    }

    @Test
    public void testGetTicketsCount() {
        List<LottoNumbers> tickets = new ArrayList<>();
        tickets.add(new LottoNumbers(new HashSet<>(Arrays.asList(1, 2, 7, 8, 9, 11))));
        tickets.add(new LottoNumbers(new HashSet<>(Arrays.asList(1, 2, 3, 7, 8, 9))));
        LottoTickets lottoTickets = new LottoTickets(tickets);

        assertThat(lottoTickets.getTicketsCount()).isEqualTo(2);
    }
}


