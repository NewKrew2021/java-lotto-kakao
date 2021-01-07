package lotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomUtilTest {

    @Test
    @DisplayName("랜덤값의 범위가 1~45이내인지 확인")
    public void testRandomValueRange(){

        int randomValue=RandomUtil.getRandomValue();
        assertThat(randomValue).isBetween(1,45);
    }

}
