package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WinningInfoTest {

    @Test
    @DisplayName("winningInfo 객체 생성 테스트")
    void create() {
        WinningInfo winningInfo = new WinningInfo(Arrays.asList(1, 1, 1, 1, 1));
        assertThat(winningInfo).isEqualTo(new WinningInfo(Arrays.asList(1, 1, 1, 1, 1)));
    }
}
