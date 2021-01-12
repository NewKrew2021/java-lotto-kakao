package view;

import domain.LottoResult;
import domain.LottoStatus;
import domain.Lottos;

import java.util.Map;
import java.util.Scanner;

public class LottoSimulatorView {
    private static final Scanner scanner = new Scanner(System.in);

    public int askMoneyToBuyLotto() {
        System.out.println(Message.ASK_MONEY_MESSAGE);
        return Integer.parseInt(scanner.nextLine());
    }

    public String askLottoNumberToAnswerLotto() {
        System.out.println(Message.ASK_LOTTO_NUMBER_FOR_ANSWER_LOTTO_MESSAGE);
        return scanner.nextLine();
    }

    public int askBonusNumberToAnswerLotto() {
        System.out.println(Message.ASK_BONUS_NUMBER_FOR_ANSWER_LOTTO_MESSAGE);
        return Integer.parseInt(scanner.nextLine());
    }

    public void printBuyLottoCount(long lottoCount) {
        System.out.println(lottoCount + Message.LOTTO_COUNT_MESSAGE);
    }

    public void printLottos(Lottos lottos) {
        System.out.println(lottos);
    }

    public void printResult(LottoResult lottoResult, long profit) {
        System.out.println("당첨 통계\n-----------");

        for (LottoStatus lottoStatus : LottoStatus.values()) {
            System.out.printf(Message.RESULT_MESSAGE, lottoStatus.getMatchedLottoNumberCount(),
                    printBonus(lottoStatus), lottoStatus.getWinngs(), lottoResult.get(lottoStatus));
        }

        System.out.println("총 수익률은 " + profit + "% 입니다.");
    }

    private String printBonus(LottoStatus lottoStatus) {
        if (lottoStatus.getWinngs() == LottoStatus.SECOND.getWinngs()) {
            return ", 보너스 볼 일치";
        }
        return "";
    }

}

