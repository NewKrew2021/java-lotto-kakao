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
    public static final String RESULT_HEAD_MESSAGE = "당첨 통계\n-----------";
    public static final String TOTAL_EARNINGS_MESSAGE = "총 수익률은 %d%% 입니다.";
    public static final String MATCHING_INFORMATION_MESSAGE = "%d개 일치(%d원)- %d개";

    public long askMoneyForBuyLotto() {
        System.out.println(ASK_MONEY_MESSAGE);
        return Long.parseLong(scanner.nextLine());
    }

    public String askLottoNumberForAnswerLotto() {
        System.out.println(ASK_LOTTO_NUMBER_FOR_ANSWER_LOTTO_MESSAGE);
        return scanner.nextLine();
    }

    public int askBonusNumberForAnswerLotto() {
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
        System.out.println(RESULT_HEAD_MESSAGE);

        for (LottoStatus lottoStatus : LottoStatus.getLottoStatuses()) {
            System.out.println(getMatchingInformation(lottoResult.get(lottoStatus), lottoStatus));
        }

        System.out.println(String.format(TOTAL_EARNINGS_MESSAGE, profit));
    }

    private String getMatchingInformation(int matchedLottoNumberCount, LottoStatus lottoStatus) {
        return String.format(MATCHING_INFORMATION_MESSAGE, lottoStatus.getMatchedLottoNumberCount(),
                lottoStatus.getWinnings(), matchedLottoNumberCount);
    }

}
