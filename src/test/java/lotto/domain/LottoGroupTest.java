package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGroupTest {
    @Test
    @DisplayName("Lotto 생성 테스트")
    void createTest() {
        List<Lotto> lottos = Arrays.asList(
                new Lotto("1, 2, 3, 4, 5, 6"),
                new Lotto("1, 2, 3, 4, 5, 7"));

        LottoGroup lottoGroup = new LottoGroup(lottos);

        assertThat(lottoGroup).isEqualTo(new LottoGroup(lottos));
    }

    @Test
    @DisplayName("Lotto 당첨 결과 테스트")
    void groupCheckTest() {
        List<Lotto> lottos = Arrays.asList(
                new Lotto("1, 2, 3, 4, 5, 6"),
                new Lotto("1, 2, 3, 4, 5, 7"));
        LottoGroup lottoGroup = new LottoGroup(lottos);
        Lotto winningLotto = new Lotto("1, 2, 3, 4, 5, 6");
        Ball bonusBall = Ball.of("7");
        WinningNumberSet winningNumberSet = new WinningNumberSet(winningLotto, bonusBall);
        LottoResult lottoResult = lottoGroup.getLottoResult(winningNumberSet);

        int firstRankCount = lottoResult.getRankCount(Rank.FIRST);
        int secondRankCount = lottoResult.getRankCount(Rank.SECOND);

        assertThat(firstRankCount).isEqualTo(1);
        assertThat(secondRankCount).isEqualTo(1);
    }

    @Test
    @DisplayName("구입 개수만큼 수동 Lotto를 생성하는지 테스트")
    void createManualLottoGroupTest() {
        List<String> lottoTexts = Arrays.asList("1,2,3,4,5,6", "11,12,13,14,15,16");
        LottoGroup lottoGroup = LottoGroup.createManualLottoGroup(lottoTexts);

        int lottoCount = lottoGroup.getLottoCount();

        assertThat(lottoCount).isEqualTo(2);
    }

    @Test
    @DisplayName("정해진 개수만큼 자동 Lotto를 생성하는지 테스트")
    void createRandomLottoGroupTest() {
        int quantity = 10;
        LottoGroup lottoGroup = LottoGroup.createRandomLottoGroup(quantity);

        int lottoCount = lottoGroup.getLottoCount();

        assertThat(lottoCount).isEqualTo(quantity);
    }

    @Test
    @DisplayName("주어진 조건에 맞추어 Lotto를 생성하는지 테스트")
    void createLottoGroupTest() {
        PurchaseMoney purchaseMoney = new PurchaseMoney("4000");
        List<String> lottoTexts = Arrays.asList("1,2,3,4,5,6", "11,12,13,14,15,16");
        LottoGroup lottoGroup = LottoGroup.createLottoGroup(purchaseMoney, lottoTexts);

        int lottoCount = lottoGroup.getLottoCount();

        assertThat(lottoCount).isEqualTo(4);
    }
}
