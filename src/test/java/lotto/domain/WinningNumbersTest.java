package lotto.domain;

import lotto.domain.dto.LottoNumber;
import lotto.domain.dto.WinningNumbers;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class WinningNumbersTest {
    @Test
    void bonusIsNotDuplicated() {
        LottoNumbers luckyNumbers = new LottoNumbers(Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::new)
                .collect(Collectors.toList()));
        LottoNumber bonusNumber = new LottoNumber(7);

        WinningNumbers winningNumbers = new WinningNumbers(luckyNumbers, bonusNumber);
        assertThat(winningNumbers).isEqualTo(new WinningNumbers(luckyNumbers, bonusNumber));
    }

    @Test
    void bonusIsDuplicatedShouldThrowError() {
        LottoNumbers luckyNumbers = new LottoNumbers(Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::new)
                .collect(Collectors.toList()));
        LottoNumber bonusNumber = new LottoNumber(1);

        assertThatThrownBy(() -> new WinningNumbers(luckyNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
