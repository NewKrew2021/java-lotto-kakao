package lotto.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LottoInputView {

    private final static Scanner scanner = new Scanner(System.in);

    public static int inputPurchaseMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        int money = 0;

        try {
            money = scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("구입금액은 정수를 입력해야합니다.");
        }

        return money;
    }

    public static String inputWinningLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        scanner.nextLine();
        return scanner.nextLine();
    }

    public static String inputBonusBall() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.next();
    }
}