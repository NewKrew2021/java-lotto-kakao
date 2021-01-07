package domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WinningInfoTest {

    @Test
    void create() {
        WinningInfo winningInfo = new WinningInfo(Arrays.asList(1, 1, 1, 1, 1));
        assertThat(winningInfo).isEqualTo(new WinningInfo(Arrays.asList(1, 1, 1, 1, 1)));
    }
}
