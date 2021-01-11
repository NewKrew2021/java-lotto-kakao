package lotto.domain.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoTicketCountTest {

    @DisplayName("티켓의 수가 주어지면, LottoTicketCount를 생성한다.")
    @Test
    void createWithTicketCount() {
        //given
        int ticketCount = 1;

        //when
        LottoTicketCount count = new LottoTicketCount(ticketCount);

        //then
        assertThat(count.getTicketCount()).isEqualTo(1);
    }

    @DisplayName("티켓의 수가 음수 또는 0으로 주어지면, 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void validateTicketCount(int given) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoTicketCount(given))
                .withMessage("티켓의 갯수는 양의 정수여야 합니다.");
    }

    @DisplayName("금액이 들어오면, 금액의 단위에 맞는 티켓의 갯수를 반환한다.")
    @Test
    void createWithMoney() {
        //given
        int money = 14000;

        //when
        LottoTicketCount count = LottoTicketCount.fromMoney(money);

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
                .isThrownBy(() -> LottoTicketCount.fromMoney(money))
                .withMessage("1000원 단위의 금액만 허용됩니다.");
    }

    @DisplayName("처음 구입한 티켓의 갯수만큼 티켓을 사용하면, 티켓이 모두 사용된다. 그보다 적게 사용했다면 티켓이 남아있다.")
    @ParameterizedTest
    @CsvSource({"2,true", "3,false"})
    void remain(int useCount, boolean expected) {
        //given
        LottoTicketCount count = LottoTicketCount.fromMoney(3000);

        //when
        for (int i = 0; i < useCount; i++) {
            count.useTicket();
        }

        //then
        assertThat(count.isTicketRemain()).isEqualTo(expected);
    }

    @DisplayName("티켓이 주어지면 원래 가격을 구한다.")
    @Test
    void calculatePrice() {
        //given
        int money = 3000;
        LottoTicketCount count = LottoTicketCount.fromMoney(money);

        //when
        int result = count.calculatePrice();

        //then
        assertThat(result).isEqualTo(money);
    }
}
