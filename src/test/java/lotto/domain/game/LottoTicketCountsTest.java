package lotto.domain.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @DisplayName("수동 티켓의 갯수만큼 티켓을 사용하면, 티켓이 모두 사용된다. 그보다 적게 사용했다면 티켓이 남아있다.")
    @ParameterizedTest
    @CsvSource({"4,true", "5,false"})
    void useAndRemainManual(int useCount, boolean expected) {
        LottoTicketCounts lottoTicketCounts = LottoTicketCounts.from(11000, 5);

        //when
        for (int i = 0; i < useCount; i++) {
            lottoTicketCounts.useManualTicket();
        }

        //then
        assertAll(
                () -> assertThat(lottoTicketCounts.isManualTicketRemain()).isEqualTo(expected),
                () -> assertThat(lottoTicketCounts.isAutoTicketRemain()).isTrue()
        );
    }

    @DisplayName("자동 티켓의 갯수만큼 티켓을 사용하면, 티켓이 모두 사용된다. 그보다 적게 사용했다면 티켓이 남아있다.")
    @ParameterizedTest
    @CsvSource({"5,true", "6,false"})
    void useAndRemainAuto(int useCount, boolean expected) {
        LottoTicketCounts lottoTicketCounts = LottoTicketCounts.from(11000, 5);

        //when
        for (int i = 0; i < useCount; i++) {
            lottoTicketCounts.useAutoTicket();
        }

        //then
        assertAll(
                () -> assertThat(lottoTicketCounts.isAutoTicketRemain()).isEqualTo(expected),
                () -> assertThat(lottoTicketCounts.isManualTicketRemain()).isTrue()
        );
    }
}
