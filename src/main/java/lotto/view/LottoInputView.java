package lotto.view;

import java.util.Scanner;

public class LottoInputView {
    public static final String ASK_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String ASK_WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    public static final String ASK_BONUS_BALL_MESSAGE = "보너스 볼을 입력해 주세요.";
    private final static Scanner scanner = new Scanner(System.in);

    public static String inputPurchaseMoney() {
        System.out.println(ASK_MONEY_MESSAGE);
        return scanner.next();
    }

    public static String inputWinningLotto() {
        System.out.println(ASK_WINNING_NUMBER_MESSAGE);
        scanner.nextLine();
        return scanner.nextLine();
    }

    public static String inputBonusBall() {
        System.out.println(ASK_BONUS_BALL_MESSAGE);
        return scanner.next();
    }
}