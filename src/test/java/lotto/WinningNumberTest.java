package lotto;

import lotto.domain.LottoTicket;
import lotto.domain.Number;
import lotto.domain.WinningNumber;
import org.assertj.core.util.Sets;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class WinningNumberTest {
    private WinningNumber winningNumber;

    @BeforeEach
    void setInit(){
        winningNumber = new WinningNumber("1, 2, 3, 4, 5, 6", 7);
    }

    @Test
    void createWinningNumberTest() {
        assertThat(winningNumber.toString()).isEqualTo("[1, 2, 3, 4, 5, 6] bonusNumber : 7");
    }

    @Test
    void containBonusNumberTest(){
        assertThat(winningNumber.bonusNumberContain(new LottoTicket(Sets.newHashSet(Arrays.asList(
                new Number(1),
                new Number(2),
                new Number(3),
                new Number(4),
                new Number(5),
                new Number(7)))))).isEqualTo(true);
    }

}
