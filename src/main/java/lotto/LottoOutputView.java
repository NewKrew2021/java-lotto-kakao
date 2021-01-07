package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoOutputView {
    private final String INPUT_MONEY_PHRASE = "구입금액을 입력해주세요.";
    private final String INPUT_QUANTITY_PHRASE = "개를 구매했습니다.";
    private final String OPEN_BRACKET = "[";
    private final String CLOSE_BRACKET = "]";

    private final String INPUT_WONLOTTO_PHRASE = "지난 주 당첨 번호를 입력해주세요.";
    private final String INPUT_BONUS_BALL_PHRASE = "보너스 볼을 입력해주세요.";

    private final String WON_RESULT_PHRASE = "당첨 통계";
    private final String SAME_COUNT_PHRASE = "개 일치";
    private final String PROFIT_PHRASE = "총 수익률은 ";

    public void printInputMoneyPhrase(){
        System.out.println(INPUT_MONEY_PHRASE);
    }

    public void printInputQuantityPhrase(int quantity){
        System.out.println(quantity + INPUT_QUANTITY_PHRASE);
    }

    public void printLottos(Lottos lottos){
        System.out.println(lottos.toString());
    }

    public void printInputWonlottoPhrase(){
        System.out.println(INPUT_WONLOTTO_PHRASE);
    }

    public void printInputBonusBallPhrase(){
        System.out.println(INPUT_BONUS_BALL_PHRASE);
    }

    public void WonResultPhrase(){
        System.out.println(WON_RESULT_PHRASE);
    }

    public void printSameCountPhrase(List<Integer> rankInfo){
        for (int i = 4; i >= 0; i--) {
            System.out.println(LottoRank.values()[i].getMatchedPhrase() + "(" + LottoRank.values()[i].getMoney()+ "원)-" + rankInfo.get(i) + "개");
        }
    }

    public void printProfitRatio(int ratio){
        System.out.println(PROFIT_PHRASE + ratio + "% 입니다.");
    }

}
