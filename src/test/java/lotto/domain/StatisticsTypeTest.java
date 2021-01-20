package lotto.domain;

import lotto.domain.StatisticsType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("당첨 확인 테스트")
public class StatisticsTypeTest {

    @Test
    @DisplayName("당첨금 확인")
    void getJackpotTest() {
        int none = StatisticsType.NONE.getJackpot();
        int three = StatisticsType.THREE.getJackpot();
        int four = StatisticsType.FOUR.getJackpot();
        int five = StatisticsType.FIVE.getJackpot();
        int fiveWithBonus = StatisticsType.FIVE_WITH_BONUS.getJackpot();
        int six = StatisticsType.SIX.getJackpot();

        assertThat(none).isEqualTo(0);
        assertThat(three).isEqualTo(5000);
        assertThat(four).isEqualTo(50000);
        assertThat(five).isEqualTo(1500000);
        assertThat(fiveWithBonus).isEqualTo(30000000);
        assertThat(six).isEqualTo(2000000000);
    }

    @Test
    @DisplayName("로또 같은 번호갯수와 보너스번호 당첨 여부에 따라 Ranking enum 반환 테스트")
    void matchTicketsTest() {
        StatisticsType none = StatisticsType.matchTickets(0, false);
        StatisticsType three = StatisticsType.matchTickets(3, false);
        StatisticsType four = StatisticsType.matchTickets(4, false);
        StatisticsType five = StatisticsType.matchTickets(5, false);
        StatisticsType fiveWithBonus = StatisticsType.matchTickets(5, true);
        StatisticsType six = StatisticsType.matchTickets(6, false);

        assertThat(none).isEqualTo(StatisticsType.NONE);
        assertThat(three).isEqualTo(StatisticsType.THREE);
        assertThat(four).isEqualTo(StatisticsType.FOUR);
        assertThat(five).isEqualTo(StatisticsType.FIVE);
        assertThat(fiveWithBonus).isEqualTo(StatisticsType.FIVE_WITH_BONUS);
        assertThat(six).isEqualTo(StatisticsType.SIX);
    }

}
