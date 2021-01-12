package lotto.view;

import com.sun.tools.jdeprscan.scan.Scan;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_PURCHASE_PRICE = "구입 금액을 입력해주세요.";
    private static final String WINNING_NUMBER = "지난주 당첨 넘버를 입력해주세요.";
    private static final String BONUS_NUMBER = "보너스 볼을 입력해주세요.";
    private static final String PURCHASE_NUMBER = "개를 구매했습니다.";

    private static Scanner sc = new Scanner(System.in);

    public static int inputPurchasePrice(){
        System.out.println(INPUT_PURCHASE_PRICE);
        int price = sc.nextInt();
        System.out.println(price/1000 + PURCHASE_NUMBER);

        return price;
    }

    public static String winningNumber() {
        System.out.println(WINNING_NUMBER);
        sc.nextLine();
        return sc.nextLine();
    }

    public static int bonusNumber(){
        System.out.println(BONUS_NUMBER);
        return sc.nextInt();
    }
}
