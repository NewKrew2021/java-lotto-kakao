package lottomission.util;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class RandomUtilTest {

    @Test
    public void 랜덤값범위테스트() {
        RandomForLotto randomUtil = new RandomForLotto();
        assertThat(randomUtil.getRandomInt()).isBetween(1, 45);
    }
}
