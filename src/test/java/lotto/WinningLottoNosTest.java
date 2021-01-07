package lotto;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class WinningLottoNosTest {

    @Test
    void bonusNoTest() {
        assertThatThrownBy(()->{
            new WinningLottoNos(Arrays.asList( 1,2,3,4,5,6 ), 3);
        }).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()->{
            new WinningLottoNos(Arrays.asList( 1,2,3,4,5,6 ), 0);
        }).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()->{
            new WinningLottoNos(Arrays.asList( 1,2,3,4,5,6 ), 46);
        }).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()->{
            new WinningLottoNos(Arrays.asList( 1,2,3,3,5,5 ), 0);
        }).isInstanceOf(IllegalArgumentException.class);

        WinningLottoNos winningLottoNos = new WinningLottoNos(Arrays.asList( 1,2,3,4,5,6 ), 7);
    }

}
