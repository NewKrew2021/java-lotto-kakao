package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoRankingTest {
    @DisplayName("일치하는 번호의 갯수와 보너스 여부가 주어지면, 랭킹을 구한다.")
    @ParameterizedTest
    @CsvSource({
            "6,true,RANK_1","6,false,RANK_1",
            "5,true,RANK_2","5,false,RANK_3",
            "4,true,RANK_4","4,false,RANK_4",
            "3,true,RANK_5","3,false,RANK_5",
            "2,true,NOTHING","2,false,NOTHING",
            "1,true,NOTHING","1,false,NOTHING",
            "0,true,NOTHING","0,false,NOTHING"
    })
    void ranking(int matchNumber, boolean bonus, LottoRanking expected) {
        //when
        LottoRanking ranking = LottoRanking.find(matchNumber, bonus);

        //then
        assertThat(ranking).isEqualTo(expected);
    }
}
