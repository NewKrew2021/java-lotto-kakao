package lotto.dto;

import lotto.domain.LottoPaper;
import lotto.domain.Ticket;
import lotto.domain.WinnerBalls;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    int testScore = 2000000000 + 30000000 + 30000000 + 5000 + 0 + 0;
    List<Integer> testOrderList = Arrays.asList(1, 2, 2, 5, 6, 6);
    LottoResult result = new LottoResult(testScore, testOrderList);

    @Test
    public void getScoreTest(){
        assertThat(result.getScore()).isEqualTo(testScore);
    }

    @Test
    public void getCountOfOrderTest(){
        List<Integer> countList = new ArrayList<>();
        for(int order = 1; order <= 6; order++){
            countList.add(result.getCountOfOrder(order));
        }

        assertThat(countList).isEqualTo(Arrays.asList(1, 2, 0, 0, 1, 2));
    }

    @Test
    public void getRateTest(){
        int testInputMoney = 1000 * 6;
        double expectedRate = (double)result.getScore() / testInputMoney;
        assertThat(result.getRate(testInputMoney)).isEqualTo(expectedRate);
    }
}
