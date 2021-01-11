package lotto.dto;

import lotto.setting.Format;
import lotto.setting.Rank;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    long testScore = Rank.FIRST.getPrize() + Rank.SECOND.getPrize() +  Rank.SECOND.getPrize()
            + Rank.FIFTH.getPrize() + Rank.OUT.getPrize() + Rank.OUT.getPrize();

    List<Rank> testRankList = Arrays.asList(Rank.FIRST, Rank.SECOND, Rank.SECOND, Rank.FIFTH, Rank.OUT, Rank.OUT);
    LottoResult result = new LottoResult(testScore, testRankList);

    @Test
    public void getScoreTest(){
        assertThat(result.getScore()).isEqualTo(testScore);
    }

    @Test
    public void getCountOfOrderTest() {
        List<Integer> countList = new ArrayList<>();
        for(int order = 1; order <= 6; order++){
            countList.add(result.getCountOfOrder(order));
        }

        assertThat(countList).isEqualTo(Arrays.asList(1, 2, 0, 0, 1, 2));
    }

    @Test
    public void getRateTest() {
        int testInputMoney = Format.TICKET_PRICE * 6;
        double expectedRate = (double)result.getScore() / testInputMoney;
        assertThat(result.getRate(testInputMoney)).isEqualTo(expectedRate);
    }
}
