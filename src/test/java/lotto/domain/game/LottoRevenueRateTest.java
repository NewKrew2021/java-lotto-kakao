package lotto.domain.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;

public class LottoRevenueRateTest {

    @DisplayName("수익과 투입금액이 주어지면 그에 따른 수익률 소수점 아래 2자리까지 구한다.")
    @Test
    void create() {
        //given
        long revenue = 5000L;
        int totalTicketMoney = 14000;

        //when
        LottoRevenueRate lottoRevenueRate = LottoRevenueRate.of(revenue, totalTicketMoney);

        //then
        assertThat(lottoRevenueRate.getRate()).isEqualTo(0.35, withPrecision(2d));
    }
}
