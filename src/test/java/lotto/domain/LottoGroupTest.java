package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoGroupTest {

    @Test
    @DisplayName("LottoGroup 클래스에 올바른 입력이 주어졌을 때 정상적으로 생성되는지 확인한다.")
    void createTest() {
        List<Lotto> lottos = Arrays.asList(
                Lotto.createLottoWithText("1, 2, 3, 4, 5, 6"),
                Lotto.createLottoWithText("1, 2, 3, 4, 5, 7"));

        LottoGroup lottoGroup = new LottoGroup(lottos);
        assertThat(lottoGroup).isEqualTo(new LottoGroup(lottos));
    }

    @Test
    @DisplayName("당첨번호 세트(당첨번호+보너스볼)이 주어졌을 때, 당첨 결과를 올바르게 구하는지 확인한다.")
    void getLottoResultTest() {
        List<Lotto> lottos = Arrays.asList(
                Lotto.createLottoWithText("1, 2, 3, 4, 5, 6"),
                Lotto.createLottoWithText("1, 2, 3, 4, 5, 7"));
        LottoGroup lottoGroup = new LottoGroup(lottos);

        Lotto winningLotto = Lotto.createLottoWithText("1, 2, 3, 4, 5, 6");
        LottoNumber bonusLottoNumber = LottoNumber.valueOf("7");
        WinningNumberSet winningNumberSet = new WinningNumberSet(winningLotto, bonusLottoNumber);

        LottoResult lottoResult = lottoGroup.getLottoResult(winningNumberSet);
        assertThat(lottoResult.getRankCount(Rank.FIRST)).isEqualTo(1);
        assertThat(lottoResult.getRankCount(Rank.SECOND)).isEqualTo(1);
    }

    @Test
    @DisplayName("LottoGroup 클래스에서 로또를 랜덤으로 생성하였을 때, 구입한 수량만큼 로또가 생성되었는지 확인한다,")
    void createRandomLottoGroupTest() {
        assertThat(LottoGroup.createRandomLottoGroup(10).getLottoCount()).isEqualTo(10);
    }

    @Test
    @DisplayName("LottoGroup 클래스에서 List<String>을 이용해서 로또를 수동으로 생성했을 때, 올바르게 로또가 구입되었는지 확인한다.")
    void createManualLottoGroupTest() {
        List<Lotto> lottos = Arrays.asList(
                Lotto.createLottoWithText("1, 2, 3, 4, 5, 6"),
                Lotto.createLottoWithText("1, 2, 3, 4, 5, 7"));
        LottoGroup lottoGroup = new LottoGroup(lottos);

        List<String> manualLottoStrings = Arrays.asList("1, 2, 3, 4, 5, 6", "1, 2, 3, 4, 5, 7");

        assertThat(lottoGroup).isEqualTo(LottoGroup.createManualLottoGroup(manualLottoStrings));
    }

    @ParameterizedTest
    @DisplayName("수동 구매로 LottoGroup 클래스를 생성할 때 잘못된 로또 text가 입력되면 예외가 발생하는지 확인한다.")
    @ValueSource(strings = {"1, 2, 3, 4, 5, 5",
            "0, 1, 2, 3, 4, 5",
            "1, 2, 3, 4",
            "1, 2, 3, 4, 5, 6, 7"})
    void createManualLottoGroupExceptionTest(String lottoText) {
        assertThatThrownBy(() -> {
            List<String> manualLottoStrings = Arrays.asList(lottoText);
            LottoGroup.createManualLottoGroup(manualLottoStrings);
        }).isInstanceOf(IllegalArgumentException.class);
    }


}
