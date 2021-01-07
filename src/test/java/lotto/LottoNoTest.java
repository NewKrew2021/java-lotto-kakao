package lotto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.*;

public class LottoNoTest {

    @Test
    void LottoNoTest() {

        assertThatThrownBy(()->{
            new LottoNo(0);
        }).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()->{
            new LottoNo(46);
        }).isInstanceOf(IllegalArgumentException.class);

        LottoNo lottoNo1 = new LottoNo(1);
        LottoNo lottoNo2 = new LottoNo(45);

    }

}
