package lotto.view;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_PURCHASE_PRICE = "구입 금액을 입력해주세요.";
    private static final String WINNING_NUMBER = "지난주 당첨 넘버를 입력해주세요.";
    private static final String BONUS_NUMBER = "보너스 볼을 입력해주세요.";
    private static final String PURCHASE_NUMBER = "개를 구매했습니다.";
    private static final String PURCHASE_HAND_LOTTO_TICKET = "수동으로 구매할 로또 수를 입력해주세요.";
    private static final String PURCHASE_HAND_LOTTO_NUMBER = "수동으로 구매할 로또 번호를 입력해주세요.";


    private static Scanner sc = new Scanner(System.in);

    public static int[] inputPurchaseInfo(){
        int[] purchaseInfo = new int[2];

        System.out.println(INPUT_PURCHASE_PRICE);
        purchaseInfo[0] = Integer.parseInt(sc.nextLine());
        System.out.println(purchaseInfo[0]/1000 + PURCHASE_NUMBER + "\n");
        System.out.println(PURCHASE_HAND_LOTTO_TICKET);
        purchaseInfo[1] = Integer.parseInt(sc.nextLine());
        System.out.println(PURCHASE_HAND_LOTTO_NUMBER);

        return purchaseInfo;
    }

    public static String inputHandLottoNumber(){
        return sc.nextLine();
    }

    public static String winningNumber() {
        System.out.println(WINNING_NUMBER);
        return sc.nextLine();
    }

    public static int bonusNumber(){
        System.out.println(BONUS_NUMBER);
        return sc.nextInt();
    }
}
