package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.*;

@DisplayName("로또 번호 테스트")
public class LottoNoTest {

    @Test
    @DisplayName("로또 번호 객체 equal 함수 테스트")
    void lottoEqualTest(){
        LottoNo lotto1 = new LottoNo(1);
        LottoNo lotto2 = new LottoNo(2);
        LottoNo lotto3_1 = new LottoNo(3);
        LottoNo lotto3_2 = new LottoNo(3);

        assertThat(lotto1).isNotEqualTo(lotto2);
        assertThat(lotto3_2).isEqualTo(lotto3_1);
    }

}
