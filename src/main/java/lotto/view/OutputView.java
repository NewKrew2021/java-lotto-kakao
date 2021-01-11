package lotto.view;

import lotto.domain.*;

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
        System.out.println(lotto.getLottoResults());
    }

    public static void printLottoCount(Price price) {
        System.out.println(price.count() + "개를 구매했습니다.");
    }

}
