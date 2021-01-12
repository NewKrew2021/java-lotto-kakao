package lotto.domain;


import lotto.util.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    Lottos lottos;

    @BeforeEach
    void setUp() {
        lottos = new Lottos(Arrays.asList(
                Lotto.autoGenerate(() -> Set.of(1, 2, 3, 4, 5, 6).stream()
                        .map(LottoNumber::of)
                        .collect(Collectors.toSet())),
                Lotto.autoGenerate(() -> Set.of(1, 2, 3, 10, 11, 12).stream()
                        .map(LottoNumber::of)
                        .collect(Collectors.toSet()))
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
        assertThat(lottos.match(matchNumber)).containsExactly(Rank.SECOND, Rank.FOURTH);
    }
}
