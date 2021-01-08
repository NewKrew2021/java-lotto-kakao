package lotto.domain;

import lotto.dto.RankingsDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankingsTest {
    Rankings rankings;

    @BeforeEach
    void setUp(){
        RankingsDto rankingsDto = new RankingsDto();
        rankingsDto.getRankings().put(Rank.SECOND,1);
        rankingsDto.getRankings().put(Rank.FOURTH,1);
        rankingsDto.getRankings().put(Rank.FIFTH,1);
        rankings = new Rankings(rankingsDto.getRankings());
    }

    @Test
    void toStringTest() {
        assertThat(rankings.toString())
                .isEqualTo("3개 일치 (5000원)- 1개\n" +
                        "4개 일치 (50000원)- 1개\n" +
                        "5개 일치 (1500000원)- 0개\n" +
                        "5개 일치, 보너스 볼 일치(30000000원)- 1개\n" +
                        "6개 일치 (2000000000원)- 0개\n");
    }

    @Test
    void profitTest(){
        assertThat(rankings.getProfitRate(new Money(14000))).isEqualTo(214678);
    }
}
