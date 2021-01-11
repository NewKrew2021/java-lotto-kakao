package lotto.domain.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoTicketCountsTest {

    @DisplayName("돈과 수동으로 살 로또의 갯수가 주어지면 자동 및 수동으로 살 로또 갯수를 담는 LottoTicketCounts가 생성된다")
    @Test
    void create() {
        //given
        int money = 15000;
        int manualCount = 5;

        //when
        LottoTicketCounts lottoTicketCounts = LottoTicketCounts.from(money, manualCount);

        //then
        assertAll(
                () -> assertThat(lottoTicketCounts.getManualCount()).isEqualTo(5),
                () -> assertThat(lottoTicketCounts.getAutoCount()).isEqualTo(10)
        );
    }
}