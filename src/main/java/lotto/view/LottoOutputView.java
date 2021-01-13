package lotto.view;

import lotto.domain.Lottos;

public class LottoOutputView {

    private final String INPUT_MONEY_PHRASE = "구입금액을 입력해주세요.";
    private final String INPUT_QUANTITY_PHRASE = "개를 구매했습니다.";

    private final String INPUT_WONLOTTO_PHRASE = "지난 주 당첨 번호를 입력해주세요.";
    private final String INPUT_BONUS_BALL_PHRASE = "보너스 볼을 입력해주세요.";
    private final String INPUT_ERROR_PHRASE = "잘못된 입력입니다 다시 입력해주세요.";
    private final String INPUT_DUPLICATE_PHRASE = "이미 있는 숫자입니다. 다시 입력해주세요.";

    private final String WON_RESULT_PHRASE = "당첨 통계";
    private final String PROFIT_PHRASE = "총 수익률은 ";

    public void printInputMoneyPhrase() {
        System.out.println(INPUT_MONEY_PHRASE);
    }

    public void printInputQuantityPhrase(int quantity) {
        System.out.println(quantity + INPUT_QUANTITY_PHRASE);
    }

    public void printLottos(Lottos lottos) {
        System.out.println(lottos.toString());
    }

    public void printInputWonlottoPhrase() {
        System.out.println(INPUT_WONLOTTO_PHRASE);
    }

    public void printInputBonusBallPhrase() {
        System.out.println(INPUT_BONUS_BALL_PHRASE);
    }

    public void WonResultPhrase() {
        System.out.println(WON_RESULT_PHRASE);
    }

    public void printSameCountPhrase(String rankStatistics) {
        System.out.println(rankStatistics);
    }

    public void printProfitRatio(double ratio) {
        System.out.println(PROFIT_PHRASE + String.format("%.2f", ratio) + "입니다.");
    }

    public void printInputErrorPhrase() {
        System.out.println(INPUT_ERROR_PHRASE);
    }

}
