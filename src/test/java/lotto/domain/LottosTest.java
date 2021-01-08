package lotto.domain;


import lotto.dto.RankingsDto;
import lotto.util.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    Lottos lottos;

    @BeforeEach
    void setUp() {
        lottos = new Lottos(Arrays.asList(
                new Lotto(() -> Set.of(1, 2, 3, 4, 5, 6)),
                new Lotto(() -> Set.of(1, 2, 3, 10, 11, 12))
        ));
    }

    @Test
    @DisplayName("로또 번호들을 한줄씩 출력한다.")
    void toStringTest() {
        String expected = "[1, 2, 3, 4, 5, 6]\n"
                + "[1, 2, 3, 10, 11, 12]\n";
        assertThat(lottos.toString()).isEqualTo(expected);
    }

    @Test
    @DisplayName("로또 번호들과 당첨번호를 매칭하여 각 등수별 당첨 횟수를 구한다.")
    void match() {
        MatchNumber matchNumber = MatchNumber.of("1, 2, 3, 4, 5, 10", 6);
        RankingsDto expected = new RankingsDto();
        expected.addRank(Rank.SECOND);
        expected.addRank(Rank.FOURTH);
        assertThat(lottos.match(matchNumber).getRankings()).containsAllEntriesOf(expected.getRankings());
    }
}
