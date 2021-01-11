package view;

import lotto.Lotto;
import lotto.LottoResult;
import lotto.Lottos;

import java.util.Map;

public class OutputView {
    public static void printLottos(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            printLotto(lotto);
        }
    }

    public static void printLotto(Lotto lotto) {
        System.out.println("[" + lotto.toString() + "]");
    }

    public static void printEarningRate(long earningRate) {
        System.out.println("총 수익률은 " + earningRate + "%입니다");
    }

    public static void printStatistics(Map<LottoResult, Integer> statistics) {
        LottoResult[] printSequence = new LottoResult[]{
                LottoResult.FIFTH,
                LottoResult.FOURTH,
                LottoResult.THIRD,
                LottoResult.SECOND,
                LottoResult.FIRST
        };

        for (LottoResult lottoResult : printSequence) {
            System.out.println(lottoResult + " " + statistics.get(lottoResult) + "개");
        }
    }

    public static void printNumberOfLottos(int numberOfLottos) {
        System.out.println(numberOfLottos + "개를 구매했습니다.");
    }
}
