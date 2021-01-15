package view;

import java.util.Scanner;

public class LottoInputView {
    private static final String ASK_MONEY_MESSAGE = "구입금액을 입력해주세요.";
    private static final String ASK_LOTTO_PURCHASE_COUNT = "수동으로 구매할 로또 수를 입력하세요.";
    private static final String ASK_LOTTO_NUMBER_FOR_ANSWER_LOTTO_MESSAGE = "지난 주 당첨 번호를 입력해주세요.";
    private static final String ASK_BONUS_NUMBER_FOR_ANSWER_LOTTO_MESSAGE = "보너스 볼을 입력해주세요.";
    private static final Scanner scanner = new Scanner(System.in);

    public static int askMoneyToBuyLotto() {
        System.out.println(ASK_MONEY_MESSAGE);
        return Integer.parseInt(scanner.nextLine());
    }

    public static String askLottoNumberToAnswerLotto() {
        System.out.println(ASK_LOTTO_NUMBER_FOR_ANSWER_LOTTO_MESSAGE);
        return scanner.nextLine();
    }

    public static int askBonusNumberToAnswerLotto() {
        System.out.println(ASK_BONUS_NUMBER_FOR_ANSWER_LOTTO_MESSAGE);
        return Integer.parseInt(scanner.nextLine());
    }

    public static int askLottoPurchaseCount() {
        System.out.println(ASK_LOTTO_PURCHASE_COUNT);
        return Integer.parseInt(scanner.nextLine());
    }

    public static String inputManualLotto() {
        return scanner.nextLine();
    }
}
