package mission.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    @Test
    @DisplayName("Lottos 객체의 equals 테스트 - 숫자의 순서는 상관이 없다")
    public void LottosEqualTest() throws LottoException {
        // given
        List<List<Integer>> numList = Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5, 6),
                Arrays.asList(1, 2, 3, 4, 5, 7),
                Arrays.asList(1, 2, 3, 4, 5, 8)
        );

        // when
        Lottos lottos1 = Lottos.buyLottos(3, numList, new UserMoney(3000));
        Collections.shuffle(numList);
        Lottos lottos2 = Lottos.buyLottos(3, numList, new UserMoney(3000));

        // then
        assertThat(lottos1).isEqualTo(lottos2);
        assertThat(lottos1 == lottos2).isFalse();
    }

}
