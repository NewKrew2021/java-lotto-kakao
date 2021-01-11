package lotto.view;

import lotto.domain.LottoDto;
import lotto.domain.LottoNumber;

import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int getMoneyFromUser() {
        return scanner.nextInt();
    }

    public static int getSelfLottoCountFromUser() {
        return scanner.nextInt();
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
