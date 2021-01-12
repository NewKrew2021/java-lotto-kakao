package mission.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @DisplayName("로또 정답 객체 생성기")
    static Stream<Arguments> answerGenerator() {
        return Stream.of(
                Arguments.of(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), Number.of(7), Rank.FIRST),
                Arguments.of(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 11)), Number.of(6), Rank.SECOND),
                Arguments.of(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 11)), Number.of(7), Rank.THIRD),
                Arguments.of(new Lotto(Arrays.asList(1, 2, 3, 4, 12, 11)), Number.of(7), Rank.FOURTH),
                Arguments.of(new Lotto(Arrays.asList(1, 2, 3, 13, 12, 11)), Number.of(7), Rank.FIFTH),
                Arguments.of(new Lotto(Arrays.asList(1, 2, 11, 12, 13, 14)), Number.of(7), Rank.UNRANKED)
        );
    }

    @DisplayName("로또에 포함된 번호 체크 생성기")
    static Stream<Arguments> numGenerator() {
        return Stream.of(
                Arguments.of(1, true),
                Arguments.of(7, false)
        );
    }

    @Test
    @DisplayName("로또 객체 생성 테스트 : 숫자의 순서는 관계가 없다")
    public void create() {
        // given
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        // when
        Lotto lotto2 = new Lotto(Arrays.asList(2, 1, 3, 6, 4, 5));

        // then
        assertThat(lotto).isEqualTo(lotto2);
    }

    @ParameterizedTest
    @DisplayName("당첨 등수 계산 테스트")
    @MethodSource("answerGenerator")
    public void rankTest(Lotto numbers, Number bonusNumber, Rank rank) {
        // given
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        // when
        LottoAnswer lottoAnswer = new LottoAnswer(numbers, bonusNumber);

        // then
        assertThat(lotto.calculateRank(lottoAnswer)).isEqualTo(rank);
    }

    @Test
    @DisplayName("로또 생성 테스트 : 6자리 초과하면 예외 발생")
    public void cannotOverSixNumbers() {
        assertThatThrownBy(() ->
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6, 7))
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 생성 테스트 : 6자리 미만이면 예외 발생")
    public void cannotUnderSixNumbers() {
        assertThatThrownBy(() ->
                new Lotto(Arrays.asList(1, 2, 7))
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("특정 번호가 포함되는지 확인하는 테스트")
    @MethodSource("numGenerator")
    public void containNumberTest(int num, boolean result) {
        // given
        Lotto Lotto1 = new Lotto(Arrays.asList(3, 2, 1, 4, 5, 6));

        // when
        Number choice = Number.of(num);

        // then
        assertThat(Lotto1.isContainLottoNumber(choice)).isEqualTo(result);
    }
}
