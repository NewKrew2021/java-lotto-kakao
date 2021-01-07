package view;

import domain.LottoStatus;
import domain.Lottos;

import java.util.Map;
import java.util.Scanner;

public class LottoSimulatorView {

    private static final Scanner scanner = new Scanner(System.in);
    public static final String ASK_MONEY_MESSAGE = "구입금액을 입력해주세요.";
    public static final String LOTTO_COUNT_MESSAGE = "개를 구입했습니다.";
    public static final String ASK_LOTTO_NUMBER_FOR_ANSWER_LOTTO_MESSAGE = "지난 주 당첨 번호를 입력해주세요.";
    public static final String ASK_BONUS_NUMBER_FOR_ANSWER_LOTTO_MESSAGE = "보너스 볼을 입력해주세요.";

    public int askMoneyToBuyLotto() {
        System.out.println(ASK_MONEY_MESSAGE);
        return Integer.parseInt(scanner.nextLine());
    }

    public String askLottoNumberToAnswerLotto() {
        System.out.println(ASK_LOTTO_NUMBER_FOR_ANSWER_LOTTO_MESSAGE);
        return scanner.nextLine();
    }

    public int askBonusNumberToAnswerLotto() {
        System.out.println(ASK_BONUS_NUMBER_FOR_ANSWER_LOTTO_MESSAGE);
        return Integer.parseInt(scanner.nextLine());
    }

    public void printBuyLottoCount(long lottoCount) {
        System.out.println(lottoCount + LOTTO_COUNT_MESSAGE);
    }

    public void printLottos(Lottos lottos) {
        System.out.println(lottos);
    }

    public void printResult(Map<LottoStatus, Integer> lottoResult, long profit) {
        System.out.println("당첨 통계\n-----------");

        for (LottoStatus lottoStatus : LottoStatus.getLottoStatuses()) {
            System.out.println(lottoStatus.getMatchedLottoNumberCount() +"개 일치 (" + lottoStatus.getWinngs()
                    + "원)- " + lottoResult.get(lottoStatus) + " 개");
        }

        System.out.println("총 수익률은 " + profit + "% 입니다.");
    }

}
