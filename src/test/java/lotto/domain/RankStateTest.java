package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class RankStateTest {


    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    public void When_MatchCountIs6_Expected_RankIsFirst(boolean bonus) {
        assertThat(RankState.rank(6, bonus)).isEqualTo(RankState.FIRST);
    }

    @Test
    public void When_MatchCountIs5AndBonusMatched_Expected_RankIsSecond() {
        assertThat(RankState.rank(5, true)).isEqualTo(RankState.SECOND);
    }

    @Test
    public void When_MatchCountIs5AndNotBonusMatched_Expected_RankIsThird() {
        assertThat(RankState.rank(5, false)).isEqualTo(RankState.THIRD);
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    public void When_MatchCountIs4_Expected_RankIsFourth(boolean bonus) {
        assertThat(RankState.rank(4, bonus)).isEqualTo(RankState.FOURTH);
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    public void When_MatchCountIs3_Expected_RankIsFifth(boolean bonus) {
        assertThat(RankState.rank(3, bonus)).isEqualTo(RankState.FIFTH);
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    public void When_MatchCountIsUnder3_Expected_RankIsFail(boolean bonus) {
        assertThat(RankState.rank(2, bonus)).isEqualTo(RankState.FAIL);
        assertThat(RankState.rank(1, bonus)).isEqualTo(RankState.FAIL);
        assertThat(RankState.rank(0, bonus)).isEqualTo(RankState.FAIL);
    }
}
