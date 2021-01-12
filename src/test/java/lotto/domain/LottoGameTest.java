package lotto.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {
    public static LottoGame game;
    public static WinnerNumbers winner;
    public static LottoTickets lottoTickets;

    @BeforeAll
    public static void setUp() {
        winner = new WinnerNumbers(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6)), 10);

        List<LottoNumbers> tickets = new ArrayList<>();
        tickets.add(new LottoNumbers(new HashSet<>(Arrays.asList(1, 2, 7, 8, 9, 11))));
        tickets.add(new LottoNumbers(new HashSet<>(Arrays.asList(1, 2, 3, 7, 8, 10))));//5등
        tickets.add(new LottoNumbers(new HashSet<>(Arrays.asList(1, 2, 3, 4, 7, 8))));//4등
        tickets.add(new LottoNumbers(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 7))));//3등
        tickets.add(new LottoNumbers(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 10))));//2등
        tickets.add(new LottoNumbers(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6))));//1등
        lottoTickets = new LottoTickets(tickets);
    }

    @BeforeEach
    public void initializer() {
        game = new LottoGame();
    }

    @Test
    public void testGetLottoTicketCount() {
        int count = game.getLottoTicketCount(14050);
        assertThat(count).isEqualTo(14);
    }

    @Test
    public void testMakeLottoTickets() {
        List<List<Integer>> manualLottoNumbers = new ArrayList<>();
        manualLottoNumbers.add(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        game.makeLottoTickets(5, manualLottoNumbers);
        assertThat(game.getTicketsCount()).isEqualTo(5);
    }


    @Test
    public void testGetStatistics() {
        game.setTickets(lottoTickets);

        LottoStatistics statistics = new LottoStatistics();
        for (Ranking rank : Ranking.values()) {
            statistics.addValue(rank, 1);
        }

        assertThat(game.getStatistics(winner)).isEqualTo(statistics);
    }

    @Test
    public void testGetEarningRatio() {
        game.setTickets(lottoTickets);
        game.getStatistics(winner);

        assertThat(game.getEarningRatio()).isEqualTo((float) 338592.5);


    }

    @Test
    public void testMakeManualLottoTickets() {
        List<List<Integer>> manualLottoNumbers = new ArrayList<>();
        manualLottoNumbers.add(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
        manualLottoNumbers.add(new ArrayList<>(Arrays.asList(7, 8, 9, 10, 11, 12)));
        manualLottoNumbers.add(new ArrayList<>(Arrays.asList(13, 14, 15, 16, 17, 18)));

        List<LottoNumbers> tickets = new ArrayList<>();
        tickets.add(new LottoNumbers(new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6))));
        tickets.add(new LottoNumbers(new HashSet<>(Arrays.asList(7, 8, 9, 10, 11, 12))));
        tickets.add(new LottoNumbers(new HashSet<>(Arrays.asList(13, 14, 15, 16, 17, 18))));

        assertThat(game.makeManualLottoTickets(manualLottoNumbers)).isEqualTo(tickets);
    }
}
