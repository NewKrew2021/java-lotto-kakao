package lottoMission.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    @Test
    @DisplayName("Lottos 는 각각의 Lotto 순서가 다르더라도, 담긴 숫자가 일치하면 동일한 객체로 본다")
    public void LottosEqualTest(){
        Lottos lottos1 = new Lottos(Arrays.asList(
                new Lotto(Arrays.asList(1,2,3,4,5,6)),
                new Lotto(Arrays.asList(1,2,3,4,5,7)),
                new Lotto(Arrays.asList(1,2,3,4,5,8))
                ));

        Lottos lottos2 = new Lottos(Arrays.asList(
                new Lotto(Arrays.asList(1,2,3,4,5,6)),
                new Lotto(Arrays.asList(1,2,3,4,5,8)),
                new Lotto(Arrays.asList(1,2,3,4,5,7))
        ));
        assertThat(lottos1).isEqualTo(lottos2);
    }

    @Test
    public void LottoNotEqualTest(){
        Lottos lottos1 = new Lottos(Arrays.asList(
                new Lotto(Arrays.asList(1,2,3,4,5,6)),
                new Lotto(Arrays.asList(1,2,3,4,5,7)),
                new Lotto(Arrays.asList(1,2,3,4,5,8))
        ));

        Lottos lottos2 = new Lottos(Arrays.asList(
                new Lotto(Arrays.asList(1,2,3,4,5,6)),
                new Lotto(Arrays.asList(1,2,3,4,5,8)),
                new Lotto(Arrays.asList(9,10,11,12,13,14))
        ));


        assertThat(lottos1).isNotEqualTo(lottos2);
    }

    @Test
    public void 당첨통계테스트() {
        Lottos lottos1 = new Lottos(Arrays.asList(
                new Lotto(Arrays.asList(8, 21, 23, 41, 42, 43)),
                new Lotto(Arrays.asList(3, 5, 11, 16, 32, 38)),
                new Lotto(Arrays.asList(7, 11, 16, 35, 36, 44)),
                new Lotto(Arrays.asList(1, 8, 11, 31, 41, 42)),
                new Lotto(Arrays.asList(13, 14, 16, 38, 42, 45)),
                new Lotto(Arrays.asList(7, 11, 30, 40, 42, 43)),
                new Lotto(Arrays.asList(2, 13, 22, 32, 38, 45)),
                new Lotto(Arrays.asList(23, 25, 33, 36, 39, 41)),
                new Lotto(Arrays.asList(1, 3, 5, 14, 22, 45)),
                new Lotto(Arrays.asList(5, 9, 38, 41, 43, 44)),
                new Lotto(Arrays.asList(2, 8, 9, 18, 19, 21)),
                new Lotto(Arrays.asList(13, 14, 18, 21, 23, 35)),
                new Lotto(Arrays.asList(17, 21, 29, 37, 42, 45)),
                new Lotto(Arrays.asList(3, 8, 27, 30, 35, 44))
        ));

        LottoAnswer answer = new LottoAnswer(
                new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)), new LottoNumber(7));

        Map<LotteryWinnings, Integer> allLottoRankCount = lottos1.getAllLottoRankCount(answer);
        System.out.println(allLottoRankCount);
    }

}
