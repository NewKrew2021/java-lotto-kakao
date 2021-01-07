package LottoMission.util;

import LottoMission.util.RandomUtil;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomUtilTest {

    @Test
    public void 랜덤값범위테스트() {
        RandomUtil randomUtil = new RandomUtil();
        assertThat(randomUtil.getRandomInt()).isBetween(1, 45);
    }

}
