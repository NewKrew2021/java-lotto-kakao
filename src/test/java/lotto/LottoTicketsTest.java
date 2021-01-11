package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;

public class LottoTicketsTest {
    private LottoNumber lottoNumber;

    @BeforeEach
    void setInit(){
        lottoNumber = new LottoNumber();
    }

    @Test
    void constructorTest(){
        LottoTickets lottoTickets = new LottoTickets(IntStream.rangeClosed(1, 14)
                .mapToObj(val -> new LottoTicket(new HashSet<>(lottoNumber.getRandomNumbers())))
                .collect(Collectors.toList()));
        assertThat(lottoTickets.getLottoTickets().size()).isEqualTo(14);
    }
}
