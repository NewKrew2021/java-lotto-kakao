package lotto.domain;

import lotto.domain.vo.LottoNumber;
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
    void testGetMatchResult() {
        LottoNumbers lottoNumbers = new LottoNumbers(LottoNumberArray.asList(1, 2, 3, 4, 5, 6));
        LottoNumbers luckyNumbers6Matches = new LottoNumbers(LottoNumberArray.asList(1, 2, 3, 4, 5, 6));
        LottoNumbers luckyNumbers2Matches = new LottoNumbers(LottoNumberArray.asList(1, 2, 7, 8, 9, 10));
        WinningNumbers winningNumbersIsFirst = new WinningNumbers(luckyNumbers6Matches, LottoNumber.valueOf(7));
        WinningNumbers winningNumbersIsLose = new WinningNumbers(luckyNumbers2Matches, LottoNumber.valueOf(3));

        assertThat(winningNumbersIsFirst.getMatchResult(lottoNumbers)).isEqualTo(MatchResult.FIRST);
        assertThat(winningNumbersIsLose.getMatchResult(lottoNumbers)).isEqualTo(MatchResult.LOSE);
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
}
