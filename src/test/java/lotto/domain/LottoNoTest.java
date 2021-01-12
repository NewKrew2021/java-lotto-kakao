package lotto.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.*;

public class LottoNoTest {

    @Test
    void lottoNoConstructorTest() {
        //pass
        LottoNo lottoNo1 = new LottoNo(LottoNo.MIN_NUMBER);
        LottoNo lottoNo2 = new LottoNo(LottoNo.MAX_NUMBER);

        //error
        assertThatThrownBy(()-> new LottoNo(LottoNo.MIN_NUMBER-1)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()-> new LottoNo(LottoNo.MAX_NUMBER+1)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validLottoNoTest() {
        int underMin = LottoNo.MIN_NUMBER - 1;
        int min = LottoNo.MIN_NUMBER;
        int upperMax = LottoNo.MAX_NUMBER + 1;
        int max = LottoNo.MAX_NUMBER;

        boolean underMinValidation = LottoNo.checkValidationLottoNo(underMin);
        boolean minValidation = LottoNo.checkValidationLottoNo(min);
        boolean upperMaxValidation = LottoNo.checkValidationLottoNo(upperMax);
        boolean maxValidation = LottoNo.checkValidationLottoNo(max);

        assertThat(underMinValidation).isFalse();
        assertThat(minValidation).isTrue();
        assertThat(upperMaxValidation).isFalse();
        assertThat(maxValidation).isTrue();
    }

    @Test
    void lottoEqualTest(){
        LottoNo lotto1 = new LottoNo(1);
        LottoNo lotto2 = new LottoNo(2);
        LottoNo lotto3_1 = new LottoNo(3);
        LottoNo lotto3_2 = new LottoNo(3);

        assertThat(lotto1).isNotEqualTo(lotto2);
        assertThat(lotto3_2).isEqualTo(lotto3_1);
    }

}
