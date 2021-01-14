package lotto.view;

import lotto.domain.Lottos;

import java.math.BigDecimal;

public class LottoOutputView {
    private final String WON_RESULT_PHRASE = "당첨 통계";
    private final String PROFIT_PHRASE = "총 수익률은 ";


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
        System.out.println(PROFIT_PHRASE + ratio + "입니다.");
    }

}
