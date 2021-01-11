package lotto.domain;

import lotto.domain.dto.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumbersTest {
    @Test
    void testEquals() {
        assertThat(new LottoNumbers(LottoNumberArray.asList(1, 2, 3, 4, 5, 6)))
                .isEqualTo(new LottoNumbers(LottoNumberArray.asList(6, 5, 4, 3, 2, 1)));

        assertThat(new LottoNumbers(LottoNumberArray.asList(1, 2, 3, 4, 5, 6)))
                .isNotEqualTo(new LottoNumbers(LottoNumberArray.asList(1, 2, 3, 4, 5, 7)));
    }

    @Test
    void testGetMatchCount() {
        LottoNumbers lottoNumbers = new LottoNumbers(LottoNumberArray.asList(1, 2, 3, 4, 5, 6));
        LottoNumbers luckyNumbers6Matches = new LottoNumbers(LottoNumberArray.asList(1, 2, 3, 4, 5, 6));
        LottoNumbers luckyNumbers2Matches = new LottoNumbers(LottoNumberArray.asList(1, 2, 7, 8, 9, 10));

        assertThat(lottoNumbers.getMatchCount(luckyNumbers6Matches)).isEqualTo(6);
        assertThat(lottoNumbers.getMatchCount(luckyNumbers2Matches)).isEqualTo(2);
    }

    @ParameterizedTest
    @CsvSource({"1,true", "7,false"})
    void testContains(int number, boolean expected) {
        assertThat(new LottoNumbers(LottoNumberArray.asList(1, 2, 3, 4, 5, 6))
                .contains(LottoNumber.valueOf(number))).isEqualTo(expected);
    }

    @DisplayName("중복된 숫자, 숫자가 6개가 아닌 경우")
    @Test
    void testShouldThrowError() {
        assertThatThrownBy(() -> new LottoNumbers(LottoNumberArray.asList(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new LottoNumbers(LottoNumberArray.asList(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new LottoNumbers(LottoNumberArray.asList(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
