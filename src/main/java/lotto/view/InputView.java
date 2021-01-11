package lotto.view;

import java.util.Scanner;

public class InputView {

    public static int enterMoney() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        String money = scanner.nextLine();
        return convertToInt(money);
    }

    public static String enterWinNumbers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public static int enterBonusNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("보너스 볼을 입력해 주세요.");
        String bonusBall = scanner.nextLine();
        return convertToInt(bonusBall);
    }

    private static int convertToInt(String str) {
        int res;
        try {
            res = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalStateException("숫자를 입력해 주세요.");
        }
        return res;
    }
}
