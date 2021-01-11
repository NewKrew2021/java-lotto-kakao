package view;

import domain.LottoStatus;
import domain.Lottos;

import java.util.Map;
import java.util.Scanner;

public class LottoSimulatorView {

    private static final Scanner scanner = new Scanner(System.in);
    public static final String ASK_MONEY_MESSAGE = "구입금액을 입력해주세요.";
    public static final String LOTTO_COUNT_MESSAGE = "\n수동으로 %d장, 자동으로 %d개를 구입했습니다.";
    public static final String ASK_LOTTO_NUMBER_FOR_ANSWER_LOTTO_MESSAGE = "지난 주 당첨 번호를 입력해주세요.";
    public static final String ASK_BONUS_NUMBER_FOR_ANSWER_LOTTO_MESSAGE = "보너스 볼을 입력해주세요.";
    public static final String RESULT_HEAD_MESSAGE = "\n당첨 통계\n-----------";
    public static final String TOTAL_EARNINGS_MESSAGE = "총 수익률은 %.2f%% 입니다.";
    public static final String MATCHING_INFORMATION_MESSAGE = "%d개 일치(%d원)- %d개";
    public static final int PERCENTAGE = 100;
    public static final String ASK_SELF_LOTTO_COUNT_MESSAGE = "\n수동으로 구매할 로또 수를 입력해주세요";
    public static final String ASK_SELF_LOTTO_NUMBER_MESSAGE = "\n수동으로 구매할 번호를 입력해주세요.";

    public long askMoneyForBuyLotto() {
        System.out.println(ASK_MONEY_MESSAGE);
        long result = Long.parseLong(scanner.nextLine());
        if (result < 0) {
            throw new IllegalArgumentException("구입 금액은 음수가 될 수 없습니다.");
        }
        return result;
    }

    public long askCountForBuySelfLotto() {
        System.out.println(ASK_SELF_LOTTO_COUNT_MESSAGE);
        long result = Long.parseLong(scanner.nextLine());
        if (result < 0) {
            throw new IllegalArgumentException("구매 갯수는 음수가 될 수 없습니다.");
        }
        return result;
    }

    public String askLottoNumberForAnswerLotto() {
        System.out.println(ASK_LOTTO_NUMBER_FOR_ANSWER_LOTTO_MESSAGE);
        return scanner.nextLine();
    }

    public String askLottoNumberForMakeSelfLotto() {
        return scanner.nextLine();
    }

    public void printAskLottoNumberMakeSelfLotto() {
        System.out.println(ASK_SELF_LOTTO_NUMBER_MESSAGE);
    }

    public int askBonusNumberForAnswerLotto() {
        System.out.println(ASK_BONUS_NUMBER_FOR_ANSWER_LOTTO_MESSAGE);
        return Integer.parseInt(scanner.nextLine());
    }

    public void printBuyLottoCount(long selfLottoCount, long autoLottoCount) {
        System.out.println(String.format(LOTTO_COUNT_MESSAGE, selfLottoCount, autoLottoCount));
    }

    public void printLottos(Lottos lottos) {
        System.out.println(lottos);
    }

    public void printResult(Map<LottoStatus, Integer> lottoResult, double profit) {
        System.out.println(RESULT_HEAD_MESSAGE);

        for (LottoStatus lottoStatus : LottoStatus.getLottoStatusesExceptNone()) {
            System.out.println(getMatchingInformation(lottoResult.get(lottoStatus), lottoStatus));
        }

        System.out.println(String.format(TOTAL_EARNINGS_MESSAGE, profit * PERCENTAGE));
    }

    private String getMatchingInformation(int matchedLottoNumberCount, LottoStatus lottoStatus) {
        return String.format(MATCHING_INFORMATION_MESSAGE, lottoStatus.getMatchedLottoNumberCount(),
                lottoStatus.getWinnings(), matchedLottoNumberCount);
    }

}
