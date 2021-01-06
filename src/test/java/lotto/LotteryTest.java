package lotto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LotteryTest {
    @Test
    void Lottery(){
        List<LotteryNumber> numbers = Arrays.asList(1,4,6,7,10,32).stream()
                .map(number -> new LotteryNumber(number))
                .collect(Collectors.toList());
        Lottery lottery = new Lottery(numbers);
        assertThat(lottery).isEqualTo(new Lottery(numbers));
    }

    @Test
    void Lottery_자동생성() {
        List<LotteryNumber> numbers = Lottery.createRandomLotteryNumbers();

        Lottery lottery = new Lottery(numbers);
        assertThat(lottery).isEqualTo(new Lottery(numbers));

    }

    @Test
    void Lottery_중복검사() {
        List<LotteryNumber> numbers = Arrays.asList(1,1,2,2,3,3).stream()
                .map(LotteryNumber::new)
                .collect(Collectors.toList());

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(()-> new Lottery(numbers));
    }

    @Test
    void Lottery_길이검사() {
        List<LotteryNumber> numbers1 = Arrays.asList(1,2,3,4,5).stream()
                .map(LotteryNumber::new)
                .collect(Collectors.toList());

        List<LotteryNumber> numbers2 = Arrays.asList(1,2,3,4,5,6,7).stream()
                .map(LotteryNumber::new)
                .collect(Collectors.toList());

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(()-> new Lottery(numbers1));
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(()-> new Lottery(numbers2));

    }
}
