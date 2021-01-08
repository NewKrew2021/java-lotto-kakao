package lotto.domain;

import lotto.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGroupTest {

    @Test
    @DisplayName("LottoGroup 클래스에 올바른 입력이 주어졌을 때 정상적으로 생성되는지 확인한다.")
    void createTest() {
        List<Lotto> lottos = Arrays.asList(
                new Lotto("1, 2, 3, 4, 5, 6"),
                new Lotto("1, 2, 3, 4, 5, 7"));

        LottoGroup lottoGroup = new LottoGroup(lottos);
        assertThat(lottoGroup).isEqualTo(new LottoGroup(lottos));
    }

    @Test
    @DisplayName("당첨번호 세트(당첨번호+보너스볼)이 주어졌을 때, 당첨 결과를 올바르게 구하는지 확인한다.")
    void getLottoResultTest() {
        List<Lotto> lottos = Arrays.asList(
                new Lotto("1, 2, 3, 4, 5, 6"),
                new Lotto("1, 2, 3, 4, 5, 7"));
        LottoGroup lottoGroup = new LottoGroup(lottos);

        Lotto winningLotto = new Lotto("1, 2, 3, 4, 5, 6");
        Ball bonusBall = Ball.createBall("7");
        WinningNumberSet winningNumberSet = new WinningNumberSet(winningLotto, bonusBall);

        LottoResult lottoResult = lottoGroup.getLottoResult(winningNumberSet);
        assertThat(lottoResult.getRankCount(Rank.FIRST)).isEqualTo(1);
        assertThat(lottoResult.getRankCount(Rank.SECOND)).isEqualTo(1);
    }

    @Test
    @DisplayName("LottoGroup 클래스에서 로또를 랜덤으로 생성하였을 때, 구입한 수량만큼 로또가 생성되었는지 확인한다,")
    void createRandomLottoGroupTest() {
        assertThat(LottoGroup.createRandomLottoGroup(10).getLottoCount()).isEqualTo(10);
    }

}
