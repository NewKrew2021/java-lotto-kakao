package lotto.domain;

import lotto.exception.BonusNumberException;
import lotto.exception.FailBuyLottoException;
import lotto.exception.NumberErrorException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {
    private WinningLotto winningLotto;

    @BeforeEach
    void setUp() {
        winningLotto = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
    }

    @ParameterizedTest
    @MethodSource("generateData")
    @DisplayName("로또 매칭 테스트")
    void matchTest(List<Integer> numbers, Rank rank) {
        assertThat(winningLotto.getRankOfLotto(new Lotto(numbers))).isEqualTo(rank);
    }

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), Rank.FIRST),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 6, 7), Rank.SECOND),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 8), Rank.THIRD),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 7, 8), Rank.FOURTH),
                Arguments.of(Arrays.asList(1, 2, 3, 7, 8, 9), Rank.FIFTH)
        );
    }

    @Test
    @DisplayName("로또 번호 잘못입력에 따른 예외 테스트")
    void lottoSizeExceptionTest() {
        assertThatExceptionOfType(NumberErrorException.class)
                .isThrownBy(() -> new Lotto(Arrays.asList(1, 2, 3, 4, 5, 1)))
                .withMessageMatching("로또 번호를 잘못 입력하셨습니다.");
    }

    @Test
    @DisplayName("보너스 번호 중복에 따른 예외 테스트")
    void bonusNumberExceptionTest() {
        assertThatExceptionOfType(BonusNumberException.class)
                .isThrownBy(() -> new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 6))
                .withMessageMatching("보너스 번호를 잘못 입력하셨습니다.");
    }

}
