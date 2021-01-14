package lotto.domain;

import lotto.exception.IllegalRankStateException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class RankStateTest {

    @Test
    public void invalidRank() {
        assertThatThrownBy(() -> {
            RankState.rank(7, true);
        }).isInstanceOf(IllegalRankStateException.class);
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    public void rank_FIRST(boolean bonus) {
        assertThat(RankState.rank(6, bonus)).isEqualTo(RankState.FIRST);
    }

    @Test
    public void rank_SECOND() {
        assertThat(RankState.rank(5, true)).isEqualTo(RankState.SECOND);
    }

    @Test
    public void rank_THIRD() {
        assertThat(RankState.rank(5, false)).isEqualTo(RankState.THIRD);
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    public void rank_FOURTH(boolean bonus) {
        assertThat(RankState.rank(4, bonus)).isEqualTo(RankState.FOURTH);
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    public void rank_FIFTH(boolean bonus) {
        assertThat(RankState.rank(3, bonus)).isEqualTo(RankState.FIFTH);
    }
}
