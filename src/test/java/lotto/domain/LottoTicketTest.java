package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoTicketTest {
    @Test
    public void testCalculateRanking(){
        Set<Integer> winnerNumbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        WinnerNumbers winner = new WinnerNumbers(new LottoNumbers(winnerNumbers), 8);
        Set<Integer> numbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 8));
        LottoTicket lottoTicket = new LottoTicket(new LottoNumbers(numbers));
        assertThat(lottoTicket.calculateRanking(winner)).isEqualTo(2);
    }
}
