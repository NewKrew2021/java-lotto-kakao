package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoNumbersTest {

    @Test
    void lottoNosLengthValidTest() {
        assertThatThrownBy(()->{
            new LottoNumbers(Arrays.asList( 1,2,3,4,5,6,7 ));
        }).isInstanceOf(IllegalArgumentException.class);

        LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList( 1,2,3,4,5,6 ));
    }

    @Test
    void duplicateValidTest(){
        assertThatThrownBy(()->{
            new LottoNumbers(Arrays.asList( 1,2,3,3,5,5 ));
        }).isInstanceOf(IllegalArgumentException.class);

        LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList( 1,2,3,4,5,6 ));
    }
}
