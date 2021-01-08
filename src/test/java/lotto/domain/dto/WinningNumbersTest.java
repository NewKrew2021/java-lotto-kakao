package lotto.domain.dto;

import lotto.domain.LottoNumbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class WinningNumbersTest {
    private LottoNumbers luckyNumbers;
    private LottoNumber bonusNumber;
    private WinningNumbers winningNumbers;

    @BeforeEach
    void setUp() {
        luckyNumbers = new LottoNumbers(Stream.of(1, 2, 3, 4, 5, 6)
                .map(LottoNumber::new)
                .collect(Collectors.toList()));
        bonusNumber = new LottoNumber(7);
        winningNumbers = new WinningNumbers(luckyNumbers, bonusNumber);
    }

    @Test
    void bonusIsNotDuplicated() {
        assertThat(winningNumbers).isEqualTo(new WinningNumbers(luckyNumbers, bonusNumber));
    }

    @Test
    void bonusIsDuplicatedShouldThrowError() {
        bonusNumber = new LottoNumber(6);
        assertThatThrownBy(() -> new WinningNumbers(luckyNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void testGetLuckyNumbers() {
        assertThat(winningNumbers.getLuckyNumbers())
                .isEqualTo(new LottoNumbers(Stream.of(1, 2, 3, 4, 5, 6)
                        .map(LottoNumber::new)
                        .collect(Collectors.toList())));

        assertThat(winningNumbers.getLuckyNumbers())
                .isNotEqualTo(new LottoNumbers(Stream.of(1, 2, 3, 4, 5, 7)
                        .map(LottoNumber::new)
                        .collect(Collectors.toList())));
    }

    @Test
    void testGetBonusNumber() {
        assertThat(winningNumbers.getBonusNumber())
                .isEqualTo(new LottoNumber(7));

        assertThat(winningNumbers.getBonusNumber())
                .isNotEqualTo(new LottoNumber(6));
    }
}
