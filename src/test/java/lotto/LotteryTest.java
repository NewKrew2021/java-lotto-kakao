package lotto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LotteryTest {
    @Test
    void Lottery_자동_생성() {
        List<LotteryNumber> numbers = Lottery.createRandomLotteryNumbers();

        assertThat(new Lottery(numbers)).isEqualTo(new Lottery(numbers));
    }

    @Test
    void Lottery_수동_정상생성() {
        List<LotteryNumber> numbers = Stream.of(1, 4, 6, 7, 10, 45)
                .map(LotteryNumber::new)
                .collect(Collectors.toList());

        assertThat(new Lottery(numbers)).isEqualTo(new Lottery(numbers));
    }

    @Test
    void Lottery_수동_유효하지않은수범위() {
        /*  LotterNumberTest 에서 유효하지 않은 수 범위에 대해 테스트가 진행되기에 여기서는 공백 */
    }

    @Test
    void Lottery_수동_번호중복() {
        List<LotteryNumber> numbers = Stream.of(1, 2, 3, 4, 4, 5)
                .map(LotteryNumber::new)
                .collect(Collectors.toList());

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> new Lottery(numbers));
    }

    @Test
    void Lottery_수동_6개가아닌경우() {
        List<LotteryNumber> numbers1 = Stream.of(1, 2, 3, 4, 5)
                .map(LotteryNumber::new)
                .collect(Collectors.toList());

        List<LotteryNumber> numbers2 = Stream.of(1, 2, 3, 4, 5, 6, 7)
                .map(LotteryNumber::new)
                .collect(Collectors.toList());

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> new Lottery(numbers1));
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> new Lottery(numbers2));
    }
}
