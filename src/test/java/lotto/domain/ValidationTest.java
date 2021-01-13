package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ValidationTest {

    @Test
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
    @CsvSource(
            "'1,2,3,4,5,6|1,2,3,4,5,6|1,2,3,4,5,6|1,2,3,4,5,5|1,2,3,4,5,6'," +
                    "'3,0,46,0,7'"
    )

    void checkValidationTest(String ticketsNumbers, String bonusNumbers) {
        List<Set<Integer>> ticketsNumberListInt = CsvParsing.convertStringToTicketsNumber(ticketsNumbers);
        List<Integer> bonusNumbersIntList = CsvParsing.convertStringToIntegerList(bonusNumbers);

        boolean invalid0 = Validation.validateWinningLottoNos(ticketsNumberListInt.get(0), bonusNumbersIntList.get(0));
        boolean invalid1 = Validation.validateWinningLottoNos(ticketsNumberListInt.get(1), bonusNumbersIntList.get(1));
        boolean invalid2 = Validation.validateWinningLottoNos(ticketsNumberListInt.get(2), bonusNumbersIntList.get(2));
        boolean invalid3 = Validation.validateWinningLottoNos(ticketsNumberListInt.get(3), bonusNumbersIntList.get(3));
        boolean valid = Validation.validateWinningLottoNos(ticketsNumberListInt.get(4), bonusNumbersIntList.get(4));

        assertThat(invalid0).isFalse();
        assertThat(invalid1).isFalse();
        assertThat(invalid2).isFalse();
        assertThat(invalid3).isFalse();
        assertThat(valid).isTrue();
    }
}
