package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LotteryTest {
    List<LotteryNumber> playerNumber;
    Lottery playerLottery;
    @BeforeEach
    void setUp() {
        playerNumber = Stream.of(1, 2, 3, 4, 5, 6)
                .map(LotteryNumber::new)
                .collect(Collectors.toList());
        playerLottery = new Lottery(playerNumber);
    }

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
        /*  LotteryNumberTest 에서 유효하지 않은 수 범위에 대해 테스트가 진행되기에 여기서는 공백 */
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

    @Test
    void Lottery_당첨_3개일치_5등() {
        List<LotteryNumber> answerNumber = Stream.of(4, 1, 9, 8, 7, 6)
                .map(LotteryNumber::new)
                .collect(Collectors.toList());
        LotteryNumber bonusNumber = new LotteryNumber(10);

        int rank = playerLottery.checkRank(answerNumber, bonusNumber);
        assertThat(rank).isEqualTo(5);
    }

    @Test
    void Lottery_당첨_4개일치_4등() {
        List<LotteryNumber> answerNumber = Stream.of(1, 2, 3, 4, 7, 8)
                .map(LotteryNumber::new)
                .collect(Collectors.toList());
        LotteryNumber bonusNumber = new LotteryNumber(10);

        int rank = playerLottery.checkRank(answerNumber, bonusNumber);
        assertThat(rank).isEqualTo(4);
    }

    @Test
    void Lottery_당첨_5개일치_3등() {
        List<LotteryNumber> answerNumber = Stream.of(1, 2, 3, 4, 5, 7)
                .map(LotteryNumber::new)
                .collect(Collectors.toList());
        LotteryNumber bonusNumber = new LotteryNumber(10);

        int rank = playerLottery.checkRank(answerNumber, bonusNumber);
        assertThat(rank).isEqualTo(3);
    }

    @Test
    void Lottery_당첨_5개_보너스일치_2등() {
        List<LotteryNumber> answerNumber = Stream.of(1, 2, 3, 4, 5, 7)
                .map(LotteryNumber::new)
                .collect(Collectors.toList());
        LotteryNumber bonusNumber = new LotteryNumber(6);

        int rank = playerLottery.checkRank(answerNumber, bonusNumber);
        assertThat(rank).isEqualTo(2);
    }

    @Test
    void Lottery_당첨_6개일치_1등() {
        List<LotteryNumber> answerNumber = Stream.of(1, 2, 3, 4, 5, 6)
                .map(LotteryNumber::new)
                .collect(Collectors.toList());
        LotteryNumber bonusNumber = new LotteryNumber(7);

        int rank = playerLottery.checkRank(answerNumber, bonusNumber);
        assertThat(rank).isEqualTo(1);
    }
}
