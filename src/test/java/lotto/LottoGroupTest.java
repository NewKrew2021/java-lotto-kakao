package lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGroupTest {

    @Test
    void createTest() {
        List<Lotto> lottos = Arrays.asList(
                new Lotto("1, 2, 3, 4, 5, 6"),
                new Lotto("1, 2, 3, 4, 5, 7"));

        LottoGroup lottoGroup = new LottoGroup(lottos);
        assertThat(lottoGroup).isEqualTo(new LottoGroup(lottos));
    }

    @Test
    void groupCheckTest() {
        List<Lotto> lottos = Arrays.asList(
                new Lotto("1, 2, 3, 4, 5, 6"),
                new Lotto("1, 2, 3, 4, 5, 7"));
        LottoGroup lottoGroup = new LottoGroup(lottos);

        WinningNumberSet winningNumberSet = new WinningNumberSet("1, 2, 3, 4, 5, 6", "7");

        LottoResult lottoResult = lottoGroup.getLottoResult(winningNumberSet);
        assertThat(lottoResult.getRankCount(Rank.FIRST)).isEqualTo(1);
        assertThat(lottoResult.getRankCount(Rank.SECOND)).isEqualTo(1);
    }

    @Test
    void createRandomLottoGroupTest() {
        assertThat(LottoGroup.createRandomLottoGroup(10).getLottoCount()).isEqualTo(10);
    }

}
