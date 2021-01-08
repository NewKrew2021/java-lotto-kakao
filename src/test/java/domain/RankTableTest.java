package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RankTableTest {
    @Test
    void rankTableGetOneMatchTest() {
        assertThat(RankTable.get(1, false)).isNull();
        assertThat(RankTable.get(1, true)).isNull();
    }

    @Test
    void rankTableGetTwoMatchTest(){
        assertThat(RankTable.get(2, false)).isNull();
        assertThat(RankTable.get(2, true)).isNull();
    }

    @Test
    void rankTableGetThreeMatchTest(){
        assertThat(RankTable.get(3, false))
                .isEqualTo(LottoRank.FIFTH);
        assertThat(RankTable.get(3, true))
                .isEqualTo(LottoRank.FIFTH);
    }

    @Test
    void rankTableGetFourMatchTest(){
        assertThat(RankTable.get(4, false))
                .isEqualTo(LottoRank.FOURTH);
        assertThat(RankTable.get(4, true))
                .isEqualTo(LottoRank.FOURTH);
    }

    @Test
    void rankTableGetFiveMatchTest(){
        assertThat(RankTable.get(5, false))
                .isEqualTo(LottoRank.THIRD);
        assertThat(RankTable.get(5, true))
                .isEqualTo(LottoRank.SECOND);
    }

    @Test
    void rankTableGetSixMatchTest(){
        assertThat(RankTable.get(6, false))
                .isEqualTo(LottoRank.FIRST);
    }
}
