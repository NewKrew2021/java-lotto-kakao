package LottoMission;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    @Test
    @DisplayName("Lottos 는 각각의 Lotto 순서가 다르더라도, 담긴 숫자가 일치하면 동일한 객체로 본다")
    public void LottosEqualTest(){
        Lottos lottos1 = new Lottos(Arrays.asList(
                new Lotto(new HashSet<>(Arrays.asList(1,2,3,4,5,6))),
                new Lotto(new HashSet<>(Arrays.asList(1,2,3,4,5,7))),
                new Lotto(new HashSet<>(Arrays.asList(1,2,3,4,5,8)))
                ));

        Lottos lottos2 = new Lottos(Arrays.asList(
                new Lotto(new HashSet<>(Arrays.asList(1,2,3,4,5,6))),
                new Lotto(new HashSet<>(Arrays.asList(1,2,3,4,5,8))),
                new Lotto(new HashSet<>(Arrays.asList(1,2,3,4,5,7)))
        ));
        assertThat(lottos1).isEqualTo(lottos2);
    }

    @Test
    public void LottoNotEqualTest(){
        Lottos lottos1 = new Lottos(Arrays.asList(
                new Lotto(new HashSet<>(Arrays.asList(1,2,3,4,5,6))),
                new Lotto(new HashSet<>(Arrays.asList(1,2,3,4,5,7))),
                new Lotto(new HashSet<>(Arrays.asList(1,2,3,4,5,8)))
        ));

        Lottos lottos2 = new Lottos(Arrays.asList(
                new Lotto(new HashSet<>(Arrays.asList(1,2,3,4,5,6))),
                new Lotto(new HashSet<>(Arrays.asList(1,2,3,4,5,8))),
                new Lotto(new HashSet<>(Arrays.asList(9,10,11,12,13,14)))
        ));


        assertThat(lottos1).isNotEqualTo(lottos2);

    }

}
