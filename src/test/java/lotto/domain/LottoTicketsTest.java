package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.*;

//import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoTicketsTest {

    @Test
    public void testCreate(){
        assertThatIllegalArgumentException().isThrownBy(() -> {
            List<LottoTicket> tickets = new ArrayList<>();
            Set<Integer> numbers = new HashSet<>(Arrays.asList(1,2,3,4,5,6));
            LottoNumbers lottoNumbers = new LottoNumbers(numbers);
            tickets.add(new LottoTicket(lottoNumbers));
            new LottoTickets(2, tickets);
        });
    }

}


