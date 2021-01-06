package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryMachineTest {
    private LotteryMachine lotteryMachine;

    @BeforeEach
    void setUp() {
        lotteryMachine = new LotteryMachine("1,2,3,4,5,6", 7);
    }

    @Test
    void raffleTest() {
        Lotto lotto = new Lotto(() -> Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lotteryMachine.raffle(lotto)).isEqualTo(1);
    }

    @Test
    void bonusTest() {
        Lotto lotto = new Lotto(() -> Arrays.asList(1, 2, 3, 4, 5, 7));
        assertThat(lotteryMachine.raffle(lotto)).isEqualTo(2);
    }

}
