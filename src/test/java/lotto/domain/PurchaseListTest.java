package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class PurchaseListTest {

    @Test
    @DisplayName("PurchaseList 객체 생성 예외처리 / 정상 생성 확인 테스트")
    void purchaseListConstructorTest() {
        assertThatThrownBy(()-> new PurchaseList(999)).isInstanceOf(IllegalArgumentException.class);

        PurchaseList purchaseList1 = new PurchaseList(1000 );
        PurchaseList purchaseList2 = new PurchaseList(50000 );
    }

    @ParameterizedTest
    @CsvSource("999,1000")
    @DisplayName("로또 티켓 금액(1000원) 미만일 때 구입실패 / 이상일 때 정상구입 확인 테스트")
    void validateInputMoney(int underTicket, int upperTicket) {
        boolean invalidTicket = PurchaseList.validateInputMoney(underTicket);
        boolean validTicket = PurchaseList.validateInputMoney(upperTicket);

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
        PurchaseList purchaseList = new PurchaseList(money, manualTickets);
        int autoTicketCount = 12;
        int manualTicketCount = 3;

        for (int i = 0; i < autoTicketCount; i++) {
            assertThat(purchaseList.payForAutoTicketing()).isTrue();
        }
        for (int i = 0; i < manualTicketCount; i++) {
            assertThat(purchaseList.payForManualTicketing()).isTrue();
        }

        assertThat(purchaseList.payForAutoTicketing()).isFalse();
        assertThat(purchaseList.payForManualTicketing()).isFalse();
    }

}
