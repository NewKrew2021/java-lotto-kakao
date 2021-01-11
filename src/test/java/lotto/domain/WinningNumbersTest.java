package lotto.domain;

import lotto.domain.dto.LottoNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumbersTest {
    private LottoNumbers luckyNumbers;
    private LottoNumber bonusNumber;
    private WinningNumbers winningNumbers;

    @BeforeEach
    void setUp() {
        luckyNumbers = new LottoNumbers(LottoNumberArray.asList(1, 2, 3, 4, 5, 6));
        bonusNumber = LottoNumber.valueOf(7);
        winningNumbers = new WinningNumbers(luckyNumbers, bonusNumber);
    }

    @Test
    void bonusIsNotDuplicated() {
        assertThat(winningNumbers).isEqualTo(new WinningNumbers(luckyNumbers, bonusNumber));
    }

    @Test
    void bonusIsDuplicatedShouldThrowError() {
        bonusNumber = LottoNumber.valueOf(6);
        assertThatThrownBy(() -> new WinningNumbers(luckyNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void testMatchLotto() {
        assertThat(winningNumbers.matchLotto(new LottoNumbers(LottoNumberArray.asList(1, 2, 3, 4, 5, 7))))
                .isEqualTo(MatchResult.SECOND);

        assertThat(winningNumbers.matchLotto(new LottoNumbers(LottoNumberArray.asList(1, 2, 3, 4, 5, 8))))
                .isEqualTo(MatchResult.THIRD);

        assertThat(winningNumbers.matchLotto(new LottoNumbers(LottoNumberArray.asList(1, 2, 3, 7, 8, 9))))
                .isEqualTo(MatchResult.FIFTH);
    }
}
