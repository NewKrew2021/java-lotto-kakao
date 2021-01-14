package domain;

import org.assertj.core.internal.bytebuddy.implementation.bind.annotation.Argument;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoResultTest {

    @ParameterizedTest
    @MethodSource("lottoResults")
    void 일등(LottoResult lottoResult, LottoStatus lottoStatus) {
        assertThat(lottoResult.getWinningMoney()).isEqualTo(lottoStatus.getWinnings());
    }

    private static Stream<Arguments> lottoResults() {
        return Stream.of(
                Arguments.of(new LottoResult(new AnswerLotto(new Lotto(Arrays.asList(1,2,3,4,5,6)),
                new LottoNumber(7)), new Lottos(new ArrayList<>(Arrays.asList(new Lotto(Arrays.asList(1,2,3,4,5,8)))))), LottoStatus.THIRD),
                Arguments.of(new LottoResult(new AnswerLotto(new Lotto(Arrays.asList(1,2,3,4,5,6)),
                        new LottoNumber(7)), new Lottos(new ArrayList<>(Arrays.asList(new Lotto(Arrays.asList(1,2,3,4,5,7)))))), LottoStatus.SECOND),
                Arguments.of(new LottoResult(new AnswerLotto(new Lotto(Arrays.asList(1,2,3,4,5,6)),
                        new LottoNumber(7)), new Lottos(new ArrayList<>(Arrays.asList(new Lotto(Arrays.asList(1,2,3,4,5,6)))))), LottoStatus.FIRST)
        );

    }

    @Test
    @DisplayName("상금 테스트")
    void winngMoneyTest() {
        LottoResult lottoResult = new LottoResult(new AnswerLotto(new Lotto(Arrays.asList(1,2,3,4,5,6)),
                new LottoNumber(7)), new Lottos(new ArrayList<>(Arrays.asList(new Lotto(Arrays.asList(1,2,3,4,5,6))))));

        assertThat(lottoResult.getWinningMoney()).isEqualTo(LottoStatus.FIRST.getWinnings());
    }
}

