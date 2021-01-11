package lotto.domain.ranking;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoBonusMatcherTest {

    @DisplayName("랭킹이 보너스를 요구하는지 아닌지 필요로하지 않는지와 보너스 넘버일치 여부가 주어졌을 때, 랭크에 맞 기대값이 나오는지 확인한는다.")
    @ParameterizedTest
    @CsvSource({
            "TRUE,true,true","TRUE,false,false",
            "FALSE,true,false","FALSE,false,true",
            "DONTCARE,true,true","DONTCARE,false,true",

    })
    void calculateBonusMatch(LottoBonusMatcher matchType, boolean bonus, boolean expected) {
        assertThat(matchType.calculate(bonus)).isEqualTo(expected);
    }
}
