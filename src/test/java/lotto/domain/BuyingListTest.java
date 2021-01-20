package lotto.domain;

import lotto.exception.WrongMoneyInputException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

@DisplayName("구입 리스트 테스트")
public class BuyingListTest {

    @Test
    @DisplayName("PurchaseList 객체 생성 예외처리 / 정상 생성 확인 테스트")
    void purchaseListConstructorTest() {
        List<Set<Integer>> manualLottoTicketNumbers = new ArrayList<>();
        assertThatThrownBy(()-> new BuyingList(999, manualLottoTicketNumbers)).isInstanceOf(WrongMoneyInputException.class);

        BuyingList buyingList1 = new BuyingList(1000, manualLottoTicketNumbers );
        BuyingList buyingList2 = new BuyingList(50000, manualLottoTicketNumbers );
    }

    @ParameterizedTest
    @CsvSource("999,1000")
    @DisplayName("로또 티켓 금액(1000원) 미만일 때 구입실패 / 이상일 때 정상구입 확인 테스트")
    void validateInputMoney(int underTicket, int upperTicket) {
        boolean invalidTicket = BuyingList.validateInputMoney(underTicket);
        boolean validTicket = BuyingList.validateInputMoney(upperTicket);

        assertThat(invalidTicket).isFalse();
        assertThat(validTicket).isTrue();
    }

    @ParameterizedTest
    @CsvSource(
            value = "15000!1,2,3,4,5,6|2,3,4,5,6,7|3,4,5,6,7,8", delimiter = '!'
    )
    @DisplayName("구매목록에서 구입에 따라 돈을 지불하는 함수 테스트")
    void payTicketTest(int money, String manualTicketNumbers) {
        List<Set<Integer>> manualTickets = CsvParsing.convertStringToTicketsNumber(manualTicketNumbers);
        BuyingList buyingList = new BuyingList(money, manualTickets);
        int autoTicketCount = 12;
        int manualTicketCount = 3;

        for (int i = 0; i < autoTicketCount; i++) {
            assertThat(buyingList.payForAutoTicketing()).isTrue();
        }
        for (int i = 0; i < manualTicketCount; i++) {
            assertThat(buyingList.payForManualTicketing()).isTrue();
        }

        assertThat(buyingList.payForAutoTicketing()).isFalse();
        assertThat(buyingList.payForManualTicketing()).isFalse();
    }

}
