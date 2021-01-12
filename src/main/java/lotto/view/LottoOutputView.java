package lotto.view;

import lotto.domain.LottoRank;
import lotto.domain.Lottos;

import java.util.List;

public class LottoOutputView {
    private static final String INPUT_MONEY_PHRASE = "구입금액을 입력해주세요.";
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

    public static void printInputQuantityPhrase(int quantity){
        System.out.println(quantity + INPUT_QUANTITY_PHRASE);
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

    public static void WonResultPhrase(){
        System.out.println(WON_RESULT_PHRASE);
    }

    public static void printSameCountPhrase(List<Integer> rankInfo){
        for (int i = 4; i >= 0; i--) {
            System.out.println(LottoRank.values()[i].getMatchedPhrase() + "(" + LottoRank.values()[i].getMoney()+ "원)-" + rankInfo.get(i) + "개");
        }
    }

    public static void printProfitRatio(int ratio){
        System.out.println(PROFIT_PHRASE + ratio + "% 입니다.");
    }

}
