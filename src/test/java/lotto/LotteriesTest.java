package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LotteriesTest {
    Lotteries lotteries;
    List<Lottery> lotteryList;

    @BeforeEach
    void setUp() {
        List<LotteryNumber> playerNumber1 = Stream.of(1, 2, 3, 4, 5, 6)
                .map(LotteryNumber::new)
                .collect(Collectors.toList());
        List<LotteryNumber> playerNumber2 = Stream.of(7, 8, 9, 10, 11, 12)
                .map(LotteryNumber::new)
                .collect(Collectors.toList());
        List<LotteryNumber> playerNumber3 = Stream.of(13, 14, 15, 16, 17, 18)
                .map(LotteryNumber::new)
                .collect(Collectors.toList());

        Lottery lottery1 = new Lottery(playerNumber1);
        Lottery lottery2 = new Lottery(playerNumber2);
        Lottery lottery3 = new Lottery(playerNumber3);

        lotteryList = Arrays.asList(lottery1, lottery2, lottery3);
        lotteries = new Lotteries(lotteryList);
    }


    @Test
    void Lotteries_생성() {
        assertThat(new Lotteries()).isEqualTo(new Lotteries());
        assertThat(lotteries).isEqualTo(new Lotteries(lotteryList));
    }

    // 당첨 번호를 입력 시, 맞은 개수 혹은 등수들을 정렬해서 반환하는 기능 구현
    @Test
    void Lotteries_등수들맵반환() {
        List<LotteryNumber> answerNumber = Stream.of(1,2,3,4,5,6)
                .map(LotteryNumber::new)
                .collect(Collectors.toList());
        LotteryNumber bonusNumber = new LotteryNumber(10);

        HashMap<Integer, Integer> rankMap = lotteries.getRanks(answerNumber, bonusNumber);

        assertThat(rankMap.get(1)).isEqualTo(1);
        assertThat(rankMap.get(2)).isEqualTo(0);
        assertThat(rankMap.get(3)).isEqualTo(0);
        assertThat(rankMap.get(4)).isEqualTo(0);
        assertThat(rankMap.get(5)).isEqualTo(0);
        assertThat(rankMap.get(Lottery.NONE)).isEqualTo(2);
    }
}