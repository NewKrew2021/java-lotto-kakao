package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @DisplayName("일치 개수와 보너스 여부가 주어졌을때 올바른 rank를 반환해야 한다.")
    @ParameterizedTest()
    @CsvSource({
            "6,false,FIRST",
            "5,true,SECOND", "5,false,THIRD",
            "4,true,FOURTH", "4,false,FOURTH",
            "3,true,FIFTH", "3,false,FIFTH",
            "2,true,NONE", "2,false,NONE",
            "1,true,NONE", "1,false,NONE",
            "0,true,NONE", "0,false,NONE"})
    public void testFindRank(int matchCount, boolean matchBonus, Rank rank) {
        assertThat(Rank.getRank(matchCount, matchBonus)).isEqualTo(rank);
    }
}
