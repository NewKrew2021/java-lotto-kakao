package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.*;

//import static org.assertj.core.api.Assertions.assertThat;

import static org.assertj.core.api.Assertions.*;

public class LottoTicketsTest {

    @Test
    public void testCreate(){
        assertThatIllegalArgumentException().isThrownBy(() -> {
            List<LottoNumbers> tickets = new ArrayList<>();
            Set<Integer> lottoNumbers = new HashSet<>(Arrays.asList(1,2,3,4,5,6));
            tickets.add(new LottoNumbers(lottoNumbers));
            new LottoTickets(2, tickets);
        });
    }



}


