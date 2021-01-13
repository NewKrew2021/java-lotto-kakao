package lotto.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.*;

public class LottoNoTest {

    @Test
    void validLottoNoTest() {
        int underMin = LottoNo.MIN_NUMBER - 1;
        int min = LottoNo.MIN_NUMBER;
        int upperMax = LottoNo.MAX_NUMBER + 1;
        int max = LottoNo.MAX_NUMBER;

        boolean underMinValidation = LottoNo.validateLottoNo(underMin);
        boolean minValidation = LottoNo.validateLottoNo(min);
        boolean upperMaxValidation = LottoNo.validateLottoNo(upperMax);
        boolean maxValidation = LottoNo.validateLottoNo(max);

        assertThat(underMinValidation).isFalse();
        assertThat(minValidation).isTrue();
        assertThat(upperMaxValidation).isFalse();
        assertThat(maxValidation).isTrue();
    }

    @Test
    void lottoEqualTest(){
        LottoNo lotto1 = LottoNo.of(1);
        LottoNo lotto2 = LottoNo.of(2);
        LottoNo lotto3_1 = LottoNo.of(3);
        LottoNo lotto3_2 = LottoNo.of(3);

        assertThat(lotto1).isNotEqualTo(lotto2);
        assertThat(lotto3_2).isEqualTo(lotto3_1);
    }

}
