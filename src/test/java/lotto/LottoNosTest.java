package lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoNosTest {

    @Test
    void lottoNosLengthValidTest() {
        assertThatThrownBy(()->{
            new LottoNos(Arrays.asList( 1,2,3,4,5,6,7 ));
        }).isInstanceOf(IllegalArgumentException.class);

        LottoNos lottoNos = new LottoNos(Arrays.asList( 1,2,3,4,5,6 ));
    }

    @Test
    void duplicateValidTest(){
        assertThatThrownBy(()->{
            new LottoNos(Arrays.asList( 1,2,3,3,5,5 ));
        }).isInstanceOf(IllegalArgumentException.class);

        LottoNos lottoNos = new LottoNos(Arrays.asList( 1,2,3,4,5,6 ));
    }
}
