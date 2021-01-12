package lotto.domain;

import lotto.exception.LottoRaffleError;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class RankTest {

    @Test
    @DisplayName("랭크 예외 테스트")
    void rankExceptionTest() {
        assertThatExceptionOfType(LottoRaffleError.class)
                .isThrownBy(() -> {
                    Rank.findRank(7, true);
                })
                .withMessageMatching("로또 추첨이 잘못되었습니다.");
    }

    @DisplayName("랭크 정확성 테스트")
    @ParameterizedTest
    @CsvSource({"6,false,1","5,true,2","5,false,3","4,false,4","3,true,5","2,true,0"})
    void rankTest(int matchCount, boolean bonusMatch, int rank){
        assertThat(Rank.findRank(matchCount,bonusMatch).getRank()).isEqualTo(rank);
    }
}
