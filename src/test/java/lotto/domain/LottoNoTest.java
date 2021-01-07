package lotto.domain;

import lotto.domain.LottoNo;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.*;

public class LottoNoTest {

    @Test
    void lottoNoTest() {

        assertThatThrownBy(()->{
            new LottoNo(0);
        }).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()->{
            new LottoNo(46);
        }).isInstanceOf(IllegalArgumentException.class);

        LottoNo lottoNo1 = new LottoNo(1);
        LottoNo lottoNo2 = new LottoNo(45);

    }

    @Test
    void lottoEqualTest(){
        LottoNo lotto1 = new LottoNo(1);
        LottoNo lotto2 = new LottoNo(2);
        assertThat(lotto1).isNotEqualTo(lotto2);

        LottoNo lotto3_1 = new LottoNo(3);
        LottoNo lotto3_2 = new LottoNo(3);
        assertThat(lotto3_2).isEqualTo(lotto3_1);
    }
}
