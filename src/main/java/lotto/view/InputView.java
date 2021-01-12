package lotto.view;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {
    private static final String INPUT_PURCHASE_PRICE = "구입 금액을 입력해주세요.";
    private static final String PURCHASE_NUMBER = "개를 구매했습니다.";
    private static final String WINNING_NUMBER = "지난주 당첨 넘버를 입력해주세요.";
    private static final String BONUS_NUMBER = "보너스 볼을 입력해주세요.";
    private static final String PURCHASE_HAND_LOTTO_TICKET = "수동으로 구매할 로또 수를 입력해주세요.";
    private static final String PURCHASE_HAND_LOTTO_NUMBER = "수동으로 구매할 로또 번호를 입력해주세요.";


    private static Scanner sc = new Scanner(System.in);

    public static int inputPurchasePrice(){
        System.out.println(INPUT_PURCHASE_PRICE);
        int price = Integer.parseInt(sc.nextLine());
        System.out.println(price/1000 + PURCHASE_NUMBER + "\n");

        return price;
    }

    public static List<String> inputHandLotto(){
        System.out.println(PURCHASE_HAND_LOTTO_TICKET);
        int handLottoTicket = Integer.parseInt(sc.nextLine());
        System.out.println(PURCHASE_HAND_LOTTO_NUMBER);

        return IntStream.rangeClosed(1, handLottoTicket)
                .mapToObj(val -> sc.nextLine())
                .collect(Collectors.toList());
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
