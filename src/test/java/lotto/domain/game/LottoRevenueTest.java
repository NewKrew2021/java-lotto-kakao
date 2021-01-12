package lotto.domain.game;

import lotto.domain.OneToSixGenerator;
import lotto.domain.number.LottoNumber;
import lotto.domain.number.LottoNumbers;
import lotto.domain.number.ManualInputStrategy;
import lotto.domain.ranking.LottoRankingCount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoRevenueTest {
    @DisplayName("투입금액과 4등 5등이 포함된 구성의 게임이 주어지면, 그에 따른 총 수익을 구한다.")
    @Test
    void create() {
        //given
        WinnerTicket winnerTicket = new WinnerTicket(LottoNumbers.from(new OneToSixGenerator()), LottoNumber.valueOf(7));
        List<LottoNumbers> lottoNumbers = Arrays.asList(
                LottoNumbers.from(new ManualInputStrategy(Arrays.asList(1, 2, 3, 10, 11, 12))),
                LottoNumbers.from(new ManualInputStrategy(Arrays.asList(1, 2, 3, 4, 11, 12))),
                LottoNumbers.from(new ManualInputStrategy(Arrays.asList(1, 2, 3, 10, 11, 12)))
        );
        int inputMoney = 10000;

        //when
        LottoRevenue lottoRevenue = LottoRevenue.of(LottoRankingCount.of(lottoNumbers, winnerTicket),
                new LottoGameCount(inputMoney));

        //then
        assertThat(lottoRevenue.calculateRevenueRate()).isEqualTo(6.0);
    }

}
