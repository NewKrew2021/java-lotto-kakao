package lotto;

import lotto.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;

public class LottoTicketsTest {
    private LottoNumber lottoNumber;
    private LottoTickets lottoTickets;

    @BeforeEach
    void setInit(){
        lottoNumber = new LottoNumber();
        lottoTickets = new LottoTickets(IntStream.rangeClosed(1, 14)
                .mapToObj(val -> new LottoTicket(new HashSet<>(lottoNumber.getRandomNumbers())))
                .collect(Collectors.toList()));
    }

    @Test
    void constructorTest(){
        assertThat(lottoTickets.getLottoTickets().size()).isEqualTo(14);
    }

    @Test
    void lottoResultsTest(){
        WinningNumber winningNumber = new WinningNumber("1, 2, 3, 4, 5, 6", 7);
        assertThat(lottoTickets.getResults(winningNumber))
                .isEqualTo(CreateLottoResults.createLottoResults(lottoTickets.getLottoTickets(), winningNumber));
    }
}
