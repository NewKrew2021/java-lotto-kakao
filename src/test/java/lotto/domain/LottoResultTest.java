package lotto.domain;

import lotto.setting.Prize;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("LottoResult 객체")
public class LottoResultTest {

    @DisplayName("객체 생성 테스트")
    @Test
    public void createTest(){
        Assertions.assertThatCode(() -> {
            new LottoResult();
        });
    }

    @DisplayName("랭크를 하나 저장하고, 그 값이 반영되었는지 확인한다.")
    @Test
    public void putRankAndGetCountOfTest(){
        LottoResult testResult = new LottoResult();
        testResult.putRank(Rank.FIRST);
        assertThat(testResult.getCountOf(Rank.FIRST)).isEqualTo(1);
    }

    @DisplayName("투입금액을 입력받으면 수익률을 계산해주는 기능 테스트")
    @Test
    public void getRateTest() {
        int testInputMoney = Ticket.TICKET_PRICE * 6;

        LottoResult testResult = new LottoResult();
        testResult.putRank(Rank.FIRST);
        testResult.putRank(Rank.SECOND);
        testResult.putRank(Rank.THIRD);
        testResult.putRank(Rank.FOURTH);
        testResult.putRank(Rank.FIFTH);
        testResult.putRank(Rank.OUT);

        long expectedSumOfPrize = Prize.MONEY_FOR_FIRST + Prize.MONEY_FOR_SECOND
                + Prize.MONEY_FOR_THIRD +Prize.MONEY_FOR_FOURTH
                + Prize.MONEY_FOR_FIFTH + Prize.MONEY_FOR_OUT;

        double expectedRate = (double)expectedSumOfPrize / testInputMoney;
        assertThat(testResult.getRate()).isEqualTo(expectedRate);
    }
}