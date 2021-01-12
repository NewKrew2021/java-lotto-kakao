package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoRankTest {

    @Test
    @DisplayName("로또의 등수가 1등일 경우")
    public void getLottoRank1(){
        assertThat(LottoRank.FIRST).isEqualTo(LottoRank.getLottoRank(6,true));
        assertThat(LottoRank.FIRST).isEqualTo(LottoRank.getLottoRank(6,false));
    }


    @Test
    @DisplayName("로또의 등수가 2등일 경우")
    public void getLottoRank2(){
        assertThat(LottoRank.SECOND).isEqualTo(LottoRank.getLottoRank(5,true));
    }


    @Test
    @DisplayName("로또의 등수가 3등일 경우")
    public void getLottoRank3(){
        assertThat(LottoRank.THIRD).isEqualTo(LottoRank.getLottoRank(5,false));
    }

    @Test
    @DisplayName("로또의 등수가 꽝일 경우")
    public void getLottoRank4(){
        assertThat(LottoRank.NONE).isEqualTo(LottoRank.getLottoRank(2,false));
        assertThat(LottoRank.NONE).isEqualTo(LottoRank.getLottoRank(1,false));
    }

}
