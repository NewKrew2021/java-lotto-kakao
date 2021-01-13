package lotto;


import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    void validate() {
        assertThatThrownBy(() -> {
            Lotto wrongLottoNumbers = Lotto.generateManualLotto(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        });

        assertThatThrownBy(() -> {
            Lotto wrongLottoNumbers = Lotto.generateManualLotto(Arrays.asList(1, 2, 3, 4, 5, 5));
        });

        Lotto correctLottoNumbers = Lotto.generateManualLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @Test
    void checkLotto() {
        Lotto winningNumbers = Lotto.generateManualLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNumber = LottoNumber.of(7);

        Lotto lotto1 = Lotto.generateManualLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = Lotto.generateManualLotto(Arrays.asList(7, 8, 9, 10, 11, 12));
        Lotto lotto3 = Lotto.generateManualLotto(Arrays.asList(3, 6, 7, 20, 45, 36));

        assertEquals(LottoResult.FIRST, lotto1.checkLotto(winningNumbers, bonusNumber));
        assertEquals(LottoResult.NOTHING, lotto2.checkLotto(winningNumbers, bonusNumber));
        assertEquals(LottoResult.NOTHING, lotto3.checkLotto(winningNumbers, bonusNumber));
    }

    /**
     *  public으로 바꾸면 테스트 가능
     * */
//    @Test
//    void countSameLottoNumber() {
//        Lotto lotto1 = Lotto.generateLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
//        Lotto lotto2 = Lotto.generateLotto(Arrays.asList(7, 8, 9, 10, 11, 12));
//        Lotto lotto3 = Lotto.generateLotto(Arrays.asList(3, 6, 7, 20, 45, 36));
//
//        assertEquals(6, lotto1.countSameLottoNumber(lotto1));
//        assertEquals(0, lotto1.countSameLottoNumber(lotto2));
//        assertEquals(2, lotto1.countSameLottoNumber(lotto3));
//    }
//
//    @Test
//    void contains() {
//        Lotto lotto = Lotto.generateLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
//        LottoNumber lottoNumber1 = LottoNumber.getInstance(1);
//        LottoNumber lottoNumber2 = LottoNumber.getInstance(3);
//        LottoNumber lottoNumber3 = LottoNumber.getInstance(7);
//
//        assertTrue(lotto.contains(lottoNumber1));
//        assertTrue(lotto.contains(lottoNumber2));
//        assertFalse(lotto.contains(lottoNumber3));
//    }
}