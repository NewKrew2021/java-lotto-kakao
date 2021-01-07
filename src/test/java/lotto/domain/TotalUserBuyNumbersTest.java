package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

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
}
