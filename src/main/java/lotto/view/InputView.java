package lotto.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int getMoneyFromUser() {
        return Integer.parseInt(scanner.nextLine());
    }

    public static int getSelfLottoCountFromUser() {
        return Integer.parseInt(scanner.nextLine());
    }

    public static String getSelfLottoNumberFromUser() {
        return scanner.nextLine();
    }

    public static String getWinningNumberFromUser() {
        return scanner.nextLine();
    }

    public static int getBonusNumberFromUser() {
        return scanner.nextInt();
    }

}
