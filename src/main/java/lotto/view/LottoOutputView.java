package lotto.view;

import lotto.domain.Lottos;

import java.math.BigDecimal;

public class LottoOutputView {
    private final String INPUT_QUANTITY_PHRASE = "개를 구매했습니다.";
    private final String WON_RESULT_PHRASE = "당첨 통계";
    private final String PROFIT_PHRASE = "총 수익률은 ";

    public void printInputQuantityPhrase(int quantity) {
        System.out.println(quantity + INPUT_QUANTITY_PHRASE);
    }

    public void printLottos(Lottos lottos) {
        System.out.println(lottos.toString());
    }

    public void WonResultPhrase() {
        System.out.println(WON_RESULT_PHRASE);
    }

    public void printSameCountPhrase(String rankStatistics) {
        System.out.println(rankStatistics);
    }

    public void printProfitRatio(BigDecimal ratio) {
        System.out.println(PROFIT_PHRASE + ratio+ "입니다.");
    }

}
