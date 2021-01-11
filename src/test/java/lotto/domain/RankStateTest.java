package lotto.domain;

import lotto.exception.IllegalRankStateException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class RankStateTest {


    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    public void rankFirst(boolean bonus) {
        assertThat(RankState.rank(6, bonus)).isEqualTo(RankState.FIRST);
    }

    @Test
    public void rankSecond() {
        assertThat(RankState.rank(5, true)).isEqualTo(RankState.SECOND);
    }

    @Test
    public void rankTHIRD() {
        assertThat(RankState.rank(5, false)).isEqualTo(RankState.THIRD);
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    public void rankFOURTH(boolean bonus) {
        assertThat(RankState.rank(4, bonus)).isEqualTo(RankState.FOURTH);
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    public void rankFIFTH(boolean bonus) {
        assertThat(RankState.rank(3, bonus)).isEqualTo(RankState.FIFTH);
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    public void rankFAIL(boolean bonus) {
        assertThat(RankState.rank(2, bonus)).isEqualTo(RankState.FAIL);
        assertThat(RankState.rank(1, bonus)).isEqualTo(RankState.FAIL);
        assertThat(RankState.rank(0, bonus)).isEqualTo(RankState.FAIL);
    }
}
