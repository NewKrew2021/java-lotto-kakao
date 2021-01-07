package lotto.domain;
import lotto.domain.LottoLogic;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.*;
public class LottoLogicTest {

    @Test
    void lottoNosLengthValidTest() {
        LottoLogic lottoLogic = new LottoLogic(10);
        assertThat(lottoLogic.getLottoCount()).isEqualTo(10);
    }


}
