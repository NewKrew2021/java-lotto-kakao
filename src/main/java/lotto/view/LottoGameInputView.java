package lotto.view;

import java.util.Scanner;

public class LottoGameInputView {

    private static Scanner scan = new Scanner(System.in);

    public static int inputPrice() {
        System.out.println("구입 금액을 입력해 주세요.");
        int price = scan.nextInt();
        scan.nextLine();
        return price;
    }

    public static String inputWinnerNumbers() {
        System.out.println("지난 주 당첨번호를 입력해 주세요.");
        String numbers = scan.nextLine();
        return numbers;
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonus = scan.nextInt();
        return bonus;
    }

}
