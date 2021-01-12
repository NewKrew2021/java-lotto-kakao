package lotto.domain.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.domain.game.LottoGameCount.LOTTO_MANUAL_EXCEPTION_MESSAGE;
import static lotto.domain.game.LottoGameCount.LOTTO_MONEY_EXCEPTION_MESSAGE;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoGameCountTest {
    @DisplayName("금액이 들어오면, 금액의 단위에 맞는 티켓의 갯수를 반환한다.")
    @Test
    void create() {
        //given
        int money = 14000;

        //when
        LottoGameCount lottogame = new LottoGameCount(money);

        //then
        assertThat(lottogame.getTicketCount()).isEqualTo(14);
    }

    @DisplayName("1000원 단위가 아닌 금액이 들어오면, 예외가 발생한다.")
    @Test
    void validateMoney1() {
        //given
        int money = 14001;

        //then
        assertThatIllegalArgumentException()
                // when
                .isThrownBy(() -> new LottoGameCount(money))
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
                .isThrownBy(() -> new LottoGameCount(money))
                .withMessage(LOTTO_MONEY_EXCEPTION_MESSAGE);
    }

    @DisplayName("게임 금액이 투입된 상태로 수동 티켓 개수가 들어오면, 수동 티켓을 입력된 숫자만큼 생성한다.")
    @Test
    void createManualTickets() {
        //given
        int money = 14000;
        int numOfManualTickets = 5;
        //when
        LottoGameCount lottoGameCount = new LottoGameCount(money, numOfManualTickets);

        //then
        assertThat(lottoGameCount.getManualTicketCount()).isEqualTo(numOfManualTickets);
    }

    @DisplayName("게임 금액이 투입된 상태로 수동 티켓 개수가 게임 횟수보다 많이 들어오면, 에러를 출력한다.")
    @Test
    void validManualTickets1() {
        //given
        int money = 14000;
        int numOfManualTickets = 15;
        //then
        assertThatIllegalArgumentException()
                // when
                .isThrownBy(() -> new LottoGameCount(money, numOfManualTickets))
                .withMessage(LOTTO_MANUAL_EXCEPTION_MESSAGE);
    }

    @DisplayName("게임 금액이 투입된 상태로 수동 티켓 개수가 음수가 들어오면, 에러를 출력한다.")
    @Test
    void validManualTickets2() {
        //given
        int money = 14000;
        int numOfManualTickets = -1;
        //then
        assertThatIllegalArgumentException()
                // when
                .isThrownBy(() -> new LottoGameCount(money, numOfManualTickets))
                .withMessage(LOTTO_MANUAL_EXCEPTION_MESSAGE);
    }

    @DisplayName("게임 금액이 투입된 상태로 수동 티켓 개수가 들어온 상태에서, 게임이 수동 티켓만큼 진행되었을 경우 수동 티켓 횟수를 끝낸다.")
    @Test
    void useManualTickets() {
        //given
        int money = 14000;
        int numOfManualTickets = 5;
        LottoGameCount lottoGameCount = new LottoGameCount(money, numOfManualTickets);

        //when
        for (int i = 0; i < 5; i++) {
            lottoGameCount.useTicket();
        }
        //then
        assertThat(lottoGameCount.isManualTicketRemain()).isEqualTo(false);
    }

}
