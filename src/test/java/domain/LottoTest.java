package domain;

import domain.Lotto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    private Lotto lotto;

    @Test
    void lottoNumberTest() {
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        assertThat(lotto.getLottoNumbers()).containsExactly(1,2,3,4,5,6);
    }

    @ParameterizedTest
    @MethodSource("provideLottosAndResults")
    void lottoPrizeResultTest(Lotto lotto, LottoStatus lottoStatus) {
        Answer answer = new Answer("1,2,3,4,5,6",7);
        assertThat(lotto.getResult(answer)).isEqualTo(lottoStatus);
    }

    @Test
    void lottoPrizeCountResultTest() {

    }

    private static Stream<Arguments> provideLottosAndResults() {
        return Stream.of(
                Arguments.of(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), LottoStatus.FIRST),
                Arguments.of(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)), LottoStatus.SECOND),
                Arguments.of(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 8)), LottoStatus.THIRD),
                Arguments.of(new Lotto(Arrays.asList(1, 2, 3, 4, 8, 9)), LottoStatus.FOURTH),
                Arguments.of(new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9)), LottoStatus.FIFTH),
                Arguments.of(new Lotto(Arrays.asList(1, 2, 7, 8, 9, 10)), null),
                Arguments.of(new Lotto(Arrays.asList(1, 8, 9, 10, 11, 12)), null),
                Arguments.of(new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12)), null)
        );
    }

}
