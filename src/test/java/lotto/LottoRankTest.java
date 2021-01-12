package lotto;

import lotto.domain.LottoRank;
import lotto.domain.LottoTicket;
import lotto.domain.Number;
import lotto.domain.WinningNumber;
import org.assertj.core.util.Sets;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import static org.assertj.core.api.Assertions.*;


public class LottoRankTest {
    @Test
    void getRankTest(){
        LottoTicket lottoTicket = new LottoTicket(
                Sets.newHashSet(Arrays.asList(
                        new Number(7),
                        new Number(2),
                        new Number(10),
                        new Number(4),
                        new Number(36),
                        new Number(6)))
        );
        WinningNumber winningNumber = new WinningNumber("1, 2, 3, 4, 5, 6", 45);

        assertThat(LottoRank.getRank(lottoTicket.matchCount(winningNumber),
                winningNumber.bonusNumberContain(lottoTicket))).isEqualTo(LottoRank.FIFTH);

    }
}
