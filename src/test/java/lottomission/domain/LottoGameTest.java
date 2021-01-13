package lottomission.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoGameTest {

    @Test
    public void 게임_결과_랭크_테스트() {
        LottoGame lottoGame = new LottoGame();

        List<List<Integer>> selfLottoList = new ArrayList<>();
        selfLottoList.add(Arrays.asList(8, 21, 23, 41, 42, 43));
        selfLottoList.add(Arrays.asList(3, 5, 11, 16, 32, 38));
        selfLottoList.add(Arrays.asList(7, 11, 16, 35, 36, 44));
        selfLottoList.add(Arrays.asList(1, 8, 11, 31, 41, 42));
        selfLottoList.add(Arrays.asList(13, 14, 16, 38, 42, 45));
        selfLottoList.add(Arrays.asList(7, 11, 30, 40, 42, 43));
        selfLottoList.add(Arrays.asList(2, 13, 22, 32, 38, 45));
        selfLottoList.add(Arrays.asList(23, 25, 33, 36, 39, 41));
        selfLottoList.add(Arrays.asList(1, 3, 5, 14, 22, 45));
        selfLottoList.add(Arrays.asList(5, 9, 38, 41, 43, 44));
        selfLottoList.add(Arrays.asList(2, 8, 9, 18, 19, 21));
        selfLottoList.add(Arrays.asList(13, 14, 18, 21, 23, 35));
        selfLottoList.add(Arrays.asList(17, 21, 29, 37, 42, 45));
        selfLottoList.add(Arrays.asList(3, 8, 27, 30, 35, 44));

        Lottos lottos = lottoGame.buyLottos(new UserMoney(14000), selfLottoList);

        LottoAnswer lottoAnswer = new LottoAnswer(
                new LottoNumbers(Arrays.asList(3, 8, 27, 30, 35, 44)),
                new LottoNumber(7)
        );

        LottoResult lottoResult = lottoGame.getLottoGameResult(lottos, lottoAnswer);
        System.out.println(lottoResult.getRankCount());
    }
}
