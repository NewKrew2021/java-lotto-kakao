package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningNumberSetTest {

    @Test
    @DisplayName("WinningNumberSet 클래스에 올바른 입력이 주어졌을 때 정상적으로 생성되는지 확인한다.")
    void createTest() {
        Lotto winningLotto = Lotto.createLottoWithText("1, 2, 3, 4, 5, 6");
        LottoNumber bonusLottoNumber = LottoNumber.valueOf("7");
        WinningNumberSet winningNumberSet = new WinningNumberSet(winningLotto, bonusLottoNumber);
        assertThat(winningNumberSet).isEqualTo(new WinningNumberSet(winningLotto, bonusLottoNumber));
    }

    @Test
    @DisplayName("WinningNumberSet 클래스에 당첨번호와 보너스번호가 중복되는 경우 예외가 발생하는지 확인한다.")
    void duplicateTest() {
        assertThatThrownBy(() -> {
            Lotto winningLotto = Lotto.createLottoWithText("1, 2, 3, 4, 5, 6");
            LottoNumber bonusLottoNumber = LottoNumber.valueOf("1");
            WinningNumberSet winningNumberSet = new WinningNumberSet(winningLotto, bonusLottoNumber);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("WinningNumberSet와 Lotto를 비교했을 때 올바르게 rank를 반환하는지 확인한다.")
    @CsvSource(value = {"1, 2, 3, 4, 5, 6| FIRST",
            "1, 2, 3, 4, 5, 7| SECOND",
            "1, 2, 3, 4, 5, 8| THIRD",
            "10, 11, 12, 13, 14, 15| NOTHING"
    }, delimiter = '|')
    void compareWithLottoTest(String lottoText, Rank rank) {
        Lotto winningLotto = Lotto.createLottoWithText("1, 2, 3, 4, 5, 6");
        LottoNumber bonusLottoNumber = LottoNumber.valueOf("7");
        WinningNumberSet winningNumberSet = new WinningNumberSet(winningLotto, bonusLottoNumber);

        Lotto lotto = Lotto.createLottoWithText(lottoText);
        assertThat(winningNumberSet.compareWithLotto(lotto)).isEqualTo(rank);
    }
}
