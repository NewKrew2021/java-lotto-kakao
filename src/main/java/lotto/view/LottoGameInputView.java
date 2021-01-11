package lotto.view;

import java.util.Scanner;

public class LottoGameInputView {

    private static Scanner scan = new Scanner(System.in);

    public static int inputPrice() {
        int price = scan.nextInt();
        scan.nextLine();
        return price;
    }

    public static String inputWinnerNumbers() {

        String numbers = scan.nextLine();
        return numbers;
    }

    public static int inputBonusNumber() {

        int bonus = scan.nextInt();
        return bonus;
    }

}
