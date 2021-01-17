package lotto.domain;

import lotto.util.Validation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ValidationTest {

    @Test
    @DisplayName("로또 번호 입력의 번호 유효성검사")
    void validLottoNoTest() {
        int underMin = LottoNo.MIN_NUMBER - 1;
        int min = LottoNo.MIN_NUMBER;
        int upperMax = LottoNo.MAX_NUMBER + 1;
        int max = LottoNo.MAX_NUMBER;

        boolean underMinValidation = Validation.validateLottoNo(underMin);
        boolean minValidation = Validation.validateLottoNo(min);
        boolean upperMaxValidation = Validation.validateLottoNo(upperMax);
        boolean maxValidation = Validation.validateLottoNo(max);

        assertThat(underMinValidation).isFalse();
        assertThat(minValidation).isTrue();
        assertThat(upperMaxValidation).isFalse();
        assertThat(maxValidation).isTrue();
    }

    @ParameterizedTest
    @CsvSource(
            "'1,2,3,3,5|1,2,3,4,5,5|1,2,3,4,5,6'"
    )
    @DisplayName("로또 티켓 입력 배열 유효성검사 / 중복 번호 혹은 잘못된 갯수 입력")
    void checkValidationLottoTicketTest(String input){
        List<Set<Integer>> ticketsNumber = CsvParsing.convertStringToTicketsNumber(input);

        boolean invalidNumberSize = Validation.validateLottoTicket(ticketsNumber.get(0));
        boolean invalidDuplication = Validation.validateLottoTicket(ticketsNumber.get(1));
        boolean validNumber = Validation.validateLottoTicket(ticketsNumber.get(2));

        assertThat(invalidNumberSize).isFalse();
        assertThat(invalidDuplication).isFalse();
        assertThat(validNumber).isTrue();
    }

    @ParameterizedTest
    @CsvSource( value = {
            "1,2,3,4,5,6 | 3",
            "1,2,3,4,5,6 | 0",
            "1,2,3,4,5,6 | 46",
            "1,2,3,4,5,5 | 4"
    }, delimiter = '|')
    @DisplayName("당첨 로또 번호의 입력 유효성 검사. / 중복번호, 잘못된 갯수 입력")
    void checkValidationTest(String ticketsNumbers, String bonusNumbers) {
        List<Set<Integer>> ticketsNumberListInt = CsvParsing.convertStringToTicketsNumber(ticketsNumbers);
        List<Integer> bonusNumbersIntList = CsvParsing.convertStringToIntegerList(bonusNumbers);

        boolean invalid = Validation.validateWinningLottoNos(ticketsNumberListInt.get(0), bonusNumbersIntList.get(0));
        assertThat(invalid).isFalse();
    }
}
