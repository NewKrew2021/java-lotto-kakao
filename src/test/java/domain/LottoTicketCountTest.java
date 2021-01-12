package domain;

import domain.exceptions.InvalidLottoTicketCountException;
import dto.Amount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class LottoTicketCountTest {

    @Test
    @DisplayName("LottoTicketCount 객체 생성 테스트")
    public void create() {
        LottoTicketCount lottoTicketCount = new LottoTicketCount(1, 1);
        assertThat(lottoTicketCount).isEqualTo(new LottoTicketCount(1, 1));
    }


    @ParameterizedTest
    @ValueSource(strings = {"", "a"})
    @DisplayName("input이 숫자가 아니면 NumberFormatException을 던진다.")
    public void testInputIsNotNumber(String input) {
        assertThatExceptionOfType(NumberFormatException.class)
                .isThrownBy(() -> new LottoTicketCount(Integer.parseInt(input), 1));
    }


    @ParameterizedTest
    @CsvSource({"2,1", "5,3", "10,9"})
    @DisplayName("구매개수가 총 구입 개수보다 크면 InvalidLottoTicketCountException을 던진다.")
    public void testInvalidLottoTicketCount(int purchaseCount, int totalCount){
        assertThatExceptionOfType(InvalidLottoTicketCountException.class)
                .isThrownBy(()->new LottoTicketCount(purchaseCount, totalCount));
    }

}
