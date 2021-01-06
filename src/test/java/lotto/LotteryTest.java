package lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteryTest {
    @Test
    void Lottery(){
        List<LotteryNumber> numbers = Arrays.asList(1,4,6,7,10,32).stream()
                .map(number -> new LotteryNumber(number))
                .collect(Collectors.toList());
        Lottery lottery = new Lottery(numbers);
        assertThat(lottery).isEqualTo(new Lottery(numbers));
    }
}
