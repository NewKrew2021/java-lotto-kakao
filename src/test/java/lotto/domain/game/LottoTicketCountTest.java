package lotto.domain.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static lotto.domain.game.LottoTicketCount.LOTTO_MONEY_EXCEPTION_MESSAGE;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoTicketCountTest {
    @DisplayName("금액이 들어오면, 금액의 단위에 맞는 티켓의 갯수를 반환한다.")
    @Test
    void create() {
        //given
        int money = 14000;

        //when
        LottoTicketCount count = new LottoTicketCount(money);

        //then
        assertThat(count.getTicketCount()).isEqualTo(14);
    }

    @DisplayName("1000원 단위가 아닌 금액이 들어오면, 예외가 발생한다.")
    @Test
    void validateMoney1() {
        //given
        int money = 14001;

        //then
        assertThatIllegalArgumentException()
                // when
                .isThrownBy(() -> new LottoTicketCount(money))
                .withMessage(LOTTO_MONEY_EXCEPTION_MESSAGE);
    }

    @DisplayName("양의 정수가 아닌 단위의 금액이 들어오면, 예외가 발생한다.")
    @Test
    void validateMoney2() {
        //given
        int money = 0;

        //then
        assertThatIllegalArgumentException()
                // when
                .isThrownBy(() -> new LottoTicketCount(money))
                .withMessage(LOTTO_MONEY_EXCEPTION_MESSAGE);
    }

    @DisplayName("처음 구입한 티켓의 갯수만큼 티켓을 사용하면, 티켓이 모두 사용된다. 그보다 적게 사용했다면 티켓이 남아있다.")
    @ParameterizedTest
    @CsvSource({"2,true", "3,false"})
    void remain(int useCount, boolean expected) {
        //given
        LottoTicketCount count = new LottoTicketCount(3000);

        //when
        for (int i = 0; i < useCount; i++) {
            count.useTicket();
        }

        //then
        assertThat(count.isTicketRemain()).isEqualTo(expected);
    }

    @DisplayName("티켓의 갯수가 주어지면 티켓들의 가격을 구한다.")
    @Test
    void totalMoney() {
        //given
        LottoTicketCount count = new LottoTicketCount(3000);

        //when
        int totalMoney = count.calculateTotalTicketMoney();

        //then
        assertThat(totalMoney).isEqualTo(3000);
    }
}
