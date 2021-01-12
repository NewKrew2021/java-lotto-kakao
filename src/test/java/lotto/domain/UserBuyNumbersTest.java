package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class UserBuyNumbersTest {

    @Test
    public void create() {
        UserBuyNumbers totalUserBuyNums = new UserBuyNumbers();
        assertThat(totalUserBuyNums).isEqualTo(new UserBuyNumbers());
    }

    @Test
    public void addNewNumbers() {
        UserBuyNumbers totalUserBuyNums1 = new UserBuyNumbers();
        totalUserBuyNums1.addBuyNumbers(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)));
        UserBuyNumbers totalUserBuyNums2 = new UserBuyNumbers();
        totalUserBuyNums2.addBuyNumbers(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)));
        assertThat(totalUserBuyNums1).isEqualTo(totalUserBuyNums2);
    }

    @Test
    public void rankResult() {
        UserBuyNumbers totalUserBuyNums = new UserBuyNumbers();
        totalUserBuyNums.addBuyNumbers(new LottoNumbers(Arrays.asList(30, 31, 32, 33, 34, 35)));
        WinningNumbers winningNumbers = new WinningNumbers("30, 31, 32, 33, 34, 40", 35);
        List<RankState> rankStates = new ArrayList<>(Arrays.asList(RankState.SECOND));
        assertThat(totalUserBuyNums.checkLottoResult(winningNumbers)).isEqualTo(rankStates);
    }

    @Test
    public void intToStringMatrix() {
        UserBuyNumbers totalUserBuyNums = new UserBuyNumbers();
        totalUserBuyNums.addBuyNumbers(new LottoNumbers(Arrays.asList(30, 31, 32, 33, 34, 35)));
        totalUserBuyNums.addBuyNumbers(new LottoNumbers(Arrays.asList(20, 21, 22, 23, 24, 25)));
        String expectedString = "[30, 31, 32, 33, 34, 35]\n[20, 21, 22, 23, 24, 25]";
        assertThat(totalUserBuyNums.toString()).isEqualTo(expectedString);
    }
}
