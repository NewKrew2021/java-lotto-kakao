package lotto.domain;

import lotto.exception.IllegalRankStateException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class RankStateTest {

    @Test
    public void invalidRank() {
        assertThatThrownBy(() -> {
            RankState.rank(7, true);
        }).isInstanceOf(IllegalRankStateException.class);
    }

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
}
