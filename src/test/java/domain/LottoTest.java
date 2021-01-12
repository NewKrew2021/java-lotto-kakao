package domain;

import domain.Lotto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    private Lotto lotto;

    @Test
    void eqaulTest() {
        lotto = new Lotto(new SelfLottoStrategy("1,2,3,4,5,6"));
        assertThat(lotto).isEqualTo(new Lotto(new SelfLottoStrategy("1,2,3,4,5,6")));
    }

    @Test
    void duplicateNumberTest() {
        assertThatThrownBy(()->{new Lotto(new SelfLottoStrategy("1,2,3,4,5,1"));})
                .hasMessage("중복된 숫자가 포함되어 있습니다.");
    }

    @ParameterizedTest
    @MethodSource("provideLottosAndResults")
    void lottoPrizeResultTest(Lotto lotto, LottoStatus lottoStatus) {
        Answer answer = new Answer(new Lotto(new SelfLottoStrategy("1,2,3,4,5,6")),7);
        assertThat(lotto.getResult(answer)).isEqualTo(lottoStatus);
    }

    @Test
    void lottoSizeInsufficientTest() {
        assertThatThrownBy(() -> { new Lotto(new SelfLottoStrategy("1,2,3,4,5")); })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("[0-9]*개의 숫자를 입력해주세요.");
    }

    @Test
    void lottoSizeExceedTest() {
        assertThatThrownBy(()->{
            new Lotto(new SelfLottoStrategy("1,2,3,4,5,6,7"));
        }).hasMessageMatching("[0-9]*개의 숫자를 입력해주세요.");
    }

    private static Stream<Arguments> provideLottosAndResults() {
        return Stream.of(
                Arguments.of(new Lotto(new SelfLottoStrategy("1,2,3,4,5,6")), LottoStatus.FIRST),
                Arguments.of(new Lotto(new SelfLottoStrategy("1,2,3,4,5,7")), LottoStatus.SECOND),
                Arguments.of(new Lotto(new SelfLottoStrategy("1,2,3,4,5,8")), LottoStatus.THIRD),
                Arguments.of(new Lotto(new SelfLottoStrategy("1,2,3,4,8,9")), LottoStatus.FOURTH),
                Arguments.of(new Lotto(new SelfLottoStrategy("1,2,3,7,8,9")), LottoStatus.FIFTH),
                Arguments.of(new Lotto(new SelfLottoStrategy("1,2,7,8,9,10")), LottoStatus.NONE),
                Arguments.of(new Lotto(new SelfLottoStrategy("1,8,9,10,11,12")), LottoStatus.NONE),
                Arguments.of(new Lotto(new SelfLottoStrategy("7,8,9,10,11,12")), LottoStatus.NONE)
        );
    }

    @Test
    void StringSplitInvalidStringExceptionTest() {
        assertThatThrownBy(()->{
            new Lotto(new SelfLottoStrategy("1,2,3,4,5,qwert"));
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("숫자가 아닌 입력이 포함되어 있습니다.");
    }
}
