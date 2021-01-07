package domain;

import domain.Lotto;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    void lottoNumberTest() {
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        assertThat(lotto.getLottoNumbers()).containsExactly(1,2,3,4,5,6);
    }

}
