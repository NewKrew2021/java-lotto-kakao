package lotto.view;

import java.util.Scanner;

public class InputView {

    private static final String MONEY_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String MANUAL_COUNT_INPUT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String MANUAL_LOTTO_INPUT_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String WIN_NUMBERS_INPUT_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final String INTEGER_WARNING_MESSAGE = " (숫자만)";

    public static int scanMoney() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(MONEY_INPUT_MESSAGE);
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.println(MONEY_INPUT_MESSAGE+INTEGER_WARNING_MESSAGE);
        }
        return scanner.nextInt();
    }

    public static int scanManualCount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(MANUAL_COUNT_INPUT_MESSAGE);
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.println(MANUAL_COUNT_INPUT_MESSAGE+INTEGER_WARNING_MESSAGE);
        }
        return scanner.nextInt();
    }

    public static void printManualLottoMessage() {
        System.out.println(MANUAL_LOTTO_INPUT_MESSAGE);
    }

    public static String scanManualLotto() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static String scanWinNumbers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(WIN_NUMBERS_INPUT_MESSAGE);
        return scanner.nextLine();
    }

    public static int scanBonusNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(BONUS_NUMBER_INPUT_MESSAGE);
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.println(BONUS_NUMBER_INPUT_MESSAGE+INTEGER_WARNING_MESSAGE);
        }
        return scanner.nextInt();
    }
}
