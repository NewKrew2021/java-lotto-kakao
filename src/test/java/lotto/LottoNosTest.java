package lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoNosTest {

    @Test
    void lottoNos() {
        assertThatThrownBy(()->{
            new LottoNos(Arrays.asList( 1,2,3,4,5,6,7 ));
        }).isInstanceOf(IllegalArgumentException.class);

        LottoNos lottoNos = new LottoNos(Arrays.asList( 1,2,3,4,5,6 ));
    }

}
