package lotto.view;

import java.util.Scanner;

public class InputView {

    public static int enterMoney() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        int money = scanner.nextInt();
        return money;
    }

    public static String enterWinNumbers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("지난 주 당첨 번호를 입력해 주세요");
        String numbers = scanner.nextLine();
        return numbers;
    }

    public static int enterBonusNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonus = scanner.nextInt();
        return bonus;
    }
}
