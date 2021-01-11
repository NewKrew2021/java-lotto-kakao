package lotto.view;

import lotto.domain.*;
import lotto.utils.Result;

import java.util.StringJoiner;

public class OutputView {
    public static void printLottos(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            printLotto(lotto);
        }
        System.out.println();
    }

    private static void printLotto(Lotto lotto) {
        StringJoiner strJoiner = new StringJoiner(", ", "[", "]");
        for (LottoNumber lottoNumber : lotto.getLottoNumbers()) {
            strJoiner.add(String.valueOf(lottoNumber.getLottoNumber()));
        }
        System.out.println(strJoiner.toString());
    }

    public static void printYield(LottoSimulation lotto) {
        System.out.println("총 수익률은 " + String.format("%.2f", lotto.getYield()) + "입니다.");
    }

    public static void printResult(LottoSimulation lotto) {
        LottoResults results = lotto.getLottoResults();
        System.out.println("3개 일치 (" + Result.THREE.getReward() + "원) - " + results.getResultCount(Result.THREE) + "개");
        System.out.println("4개 일치 (" + Result.FOUR.getReward() + "원) - " + results.getResultCount(Result.FOUR) + "개");
        System.out.println("5개 일치 (" + Result.FIVE.getReward() + "원) - " + results.getResultCount(Result.FIVE) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (" + Result.BONUSFIVE.getReward() + "원) - " + results.getResultCount(Result.BONUSFIVE) + "개");
        System.out.println("6개 일치 (" + Result.SIX.getReward() + "원) - " + results.getResultCount(Result.SIX) + "개");
    }

    public static void printLottoCount(Price price) {
        System.out.println(price.count() + "개를 구매했습니다.");
    }

}
