package lotto.domain;

import lotto.util.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RankingsTest {
    Rankings rankings;

    @BeforeEach
    void setUp(){
        List<Rank> ranks = List.of(Rank.SECOND, Rank.FOURTH, Rank.FIFTH);
        rankings = Rankings.fromRanks(ranks);
    }

    @Test
    @DisplayName("Rankings를 문자열로 반환한다.")
    void toStringTest() {
        assertThat(rankings.toString())
                .isEqualTo("3개 일치 (5000원)- 1개\n" +
                        "4개 일치 (50000원)- 1개\n" +
                        "5개 일치 (1500000원)- 0개\n" +
                        "5개 일치, 보너스 볼 일치(30000000원)- 1개\n" +
                        "6개 일치 (2000000000원)- 0개\n");
    }

    @Test
    @DisplayName("수익률을 계산하여 반환한다.")
    void profitTest(){
        assertThat(rankings.getProfitRate(new Money(14000))).isEqualTo(214678);
    }
}
