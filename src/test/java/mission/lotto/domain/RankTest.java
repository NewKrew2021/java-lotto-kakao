package mission.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @Test
    @DisplayName("1등 Rank 가져오기 테스트")
    public void rankCreateTest() {
        Rank rank = Rank.getRank(6, false);
        assertThat(rank).isEqualTo(Rank.FIRST);
    }

    @Test
    @DisplayName("2등 Rank 가져오기 테스트")
    public void rankCreateTest2() {
        Rank rank = Rank.getRank(5, true);
        assertThat(rank).isEqualTo(Rank.SECOND);
    }

    @Test
    @DisplayName("3등 이하 Rank 가져오기 테스트")
    public void rankCreateTest3() {
        Rank rank = Rank.getRank(5, false);
        assertThat(rank).isEqualTo(Rank.THIRD);

        Rank rank2 = Rank.getRank(4, true);
        assertThat(rank2).isEqualTo(Rank.FOURTH);

        Rank rank3 = Rank.getRank(4, false);
        assertThat(rank3).isEqualTo(Rank.FOURTH);

        Rank rank4 = Rank.getRank(3, true);
        assertThat(rank4).isEqualTo(Rank.FIFTH);

        Rank rank5 = Rank.getRank(3, false);
        assertThat(rank5).isEqualTo(Rank.FIFTH);

        Rank rank6 = Rank.getRank(2, true);
        assertThat(rank6).isEqualTo(Rank.UNRANKED);
    }

}
