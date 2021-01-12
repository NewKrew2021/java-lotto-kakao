package lotto.view;

import lotto.domain.LottoRank;
import lotto.domain.Lottos;

import java.util.List;

public class LottoOutputView {
    private static final String INPUT_MONEY_PHRASE = "구입금액을 입력해주세요.";
    private static final String INPUT_NON_AUTO_LOTTO_QUANTITY_PHRASE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String INPUT_NON_AUTO_LOTTO_PHRASE = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String INPUT_QUANTITY_PHRASE = "개를 구매했습니다.";
    private static final String OPEN_BRACKET = "[";
    private static final String CLOSE_BRACKET = "]";

    private static final String INPUT_WONLOTTO_PHRASE = "지난 주 당첨 번호를 입력해주세요.";
    private static final String INPUT_BONUS_BALL_PHRASE = "보너스 볼을 입력해주세요.";

    private static final String WON_RESULT_PHRASE = "당첨 통계";
    private static final String SAME_COUNT_PHRASE = "개 일치";
    private static final String PROFIT_PHRASE = "총 수익률은 ";

    public static void printInputMoneyPhrase(){
        System.out.println(INPUT_MONEY_PHRASE);
    }

    public static void printInputQuantityPhrase(int nonAuto, int auto){
        System.out.println("수동으로 " + nonAuto + "장, 자동으로" + auto + INPUT_QUANTITY_PHRASE);
    }

    public static void printLottos(Lottos lottos){
        System.out.println(lottos.toString());
    }

    public static void printInputWonlottoPhrase(){
        System.out.println(INPUT_WONLOTTO_PHRASE);
    }

    public static void printInputBonusBallPhrase(){
        System.out.println(INPUT_BONUS_BALL_PHRASE);
    }

    public static void printWonResultPhrase(){
        System.out.println(WON_RESULT_PHRASE + "\n----------------");
    }

    public static void printSameCountPhrase(List<Integer> rankInfo){
        for (int i = 4; i >= 0; i--) {
            System.out.println(LottoRank.values()[i].getMatchedPhrase() + "(" + LottoRank.values()[i].getMoney()+ "원)-" + rankInfo.get(i) + "개");
        }
    }

    public static void printProfitRatio(double ratio){
        System.out.println(PROFIT_PHRASE + ratio + "입니다.");
    }

    public static void printInputNonAutoLottoQuantityPhrase() {
        System.out.println(INPUT_NON_AUTO_LOTTO_QUANTITY_PHRASE);
    }

    public static void printInputNonAutoLottoPhrase() {
        System.out.println(INPUT_NON_AUTO_LOTTO_PHRASE);
    }
}
