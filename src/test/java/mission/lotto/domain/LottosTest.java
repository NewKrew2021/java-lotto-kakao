package mission.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottosTest {

    static Stream<Arguments> numberGenerator() {
        List<List<Integer>> numList = Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5, 6),
                Arrays.asList(1, 2, 3, 4, 5, 7),
                Arrays.asList(1, 2, 3, 4, 5, 8)
        );

        return Stream.of(
                Arguments.of(3, numList, new UserMoney(3000))
        );
    }

    @ParameterizedTest
    @MethodSource("numberGenerator")
    @DisplayName("Lottos 객체의 equals 테스트 - 숫자의 순서는 상관이 없다")
    public void LottosEqualTest(int manualCount, List<List<Integer>> numbers, UserMoney userMoney) throws LottoException {
        // when
        Lottos lottos1 = Lottos.buyLottos(manualCount, numbers, userMoney);
        Collections.shuffle(numbers);
        Lottos lottos2 = Lottos.buyLottos(manualCount, numbers, userMoney);

        // then
        assertThat(lottos1).isEqualTo(lottos2);
        assertThat(lottos1 == lottos2).isFalse();
    }

    @ParameterizedTest
    @MethodSource("numberGenerator")
    @DisplayName("Getter로 받아온 Set이 불변객체인지 확인하는 테스트")
    public void immutableTest(int manualCount, List<List<Integer>> numbers, UserMoney userMoney) {
        assertThatThrownBy(() -> {
            Lottos lottos = Lottos.buyLottos(manualCount, numbers, userMoney);
            List<Lotto> lottoList = lottos.getLottos();
            lottoList.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        }).isInstanceOf(UnsupportedOperationException.class);
    }

}
