package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TotalUserBuyNumbersTest {

    @Test
    public void create() {
        TotalUserBuyNumbers totalUserBuyNums = new TotalUserBuyNumbers();
        assertThat(totalUserBuyNums).isEqualTo(new TotalUserBuyNumbers());
    }

    @Test
    public void addNewNumbers() {
        TotalUserBuyNumbers totalUserBuyNums1 = new TotalUserBuyNumbers();
        totalUserBuyNums1.addBuyNumbers(new UserBuyNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)));
        TotalUserBuyNumbers totalUserBuyNums2 = new TotalUserBuyNumbers();
        totalUserBuyNums2.addBuyNumbers(new UserBuyNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)));
        assertThat(totalUserBuyNums1).isEqualTo(totalUserBuyNums2);
    }

    @Test
    public void getWinResult() {
        TotalUserBuyNumbers totalUserBuyNumbers = new TotalUserBuyNumbers();
        totalUserBuyNumbers.addBuyNumbers(new UserBuyNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)));
        totalUserBuyNumbers.addBuyNumbers(new UserBuyNumbers(Arrays.asList(5, 6, 7, 8, 9, 11)));
        WinAndBonusNumbers winAndBonusNumbers = new WinAndBonusNumbers(Arrays.asList(5, 6, 7, 8, 9, 10), 11);
        List<RankState> result = totalUserBuyNumbers.getAllRankResult(winAndBonusNumbers);
        List<RankState> expected = new ArrayList<>(Arrays.asList(RankState.FAIL, RankState.SECOND));
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void intToStringMatrix() {
        TotalUserBuyNumbers totalUserBuyNums = new TotalUserBuyNumbers();
        totalUserBuyNums.addBuyNumbers(new UserBuyNumbers(Arrays.asList(30, 31, 32, 33, 34, 35)));
        totalUserBuyNums.addBuyNumbers(new UserBuyNumbers(Arrays.asList(20, 21, 22, 23, 24, 25)));
        List<List<String>> expectedMatrix = new ArrayList<>();
        expectedMatrix.add(Arrays.asList("30", "31", "32", "33", "34", "35"));
        expectedMatrix.add(Arrays.asList("20","21","22","23","24","25"));
        assertThat(totalUserBuyNums.convertToString()).isEqualTo(expectedMatrix);
    }
}
