package lotto.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int getMoneyFromUser() {
        return scanner.nextInt();
    }

    public static int getSelfLottoCountFromUser() {
        return scanner.nextInt();
    }

    public static String getSelfLottoNumberFromUser() {
        scanner.nextLine();
        return scanner.nextLine();
    }

    public static String getWinningNumberFromUser() {
        return scanner.nextLine();
    }

    public static int getBonusNumberFromUser() {
        return scanner.nextInt();
    }

}
