package lotto.view;

import java.util.Scanner;

public class InputView {

    private static final String MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WIN_NUMBERS_INPUT_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 볼을 입력해 주세요.";

    public static int enterMoney() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(MONEY_INPUT_MESSAGE);
        return scanner.nextInt();
    }

    public static String enterWinNumbers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(WIN_NUMBERS_INPUT_MESSAGE);
        return scanner.nextLine();
    }

    public static int enterBonusNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(BONUS_NUMBER_INPUT_MESSAGE);
        return scanner.nextInt();
    }
}
