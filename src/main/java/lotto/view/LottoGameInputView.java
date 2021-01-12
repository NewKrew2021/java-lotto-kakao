package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LottoGameInputView {
    private static final String ASK_PRICE_SENTENCE = "구입 금액을 입력해 주세요.";
    private static final String ASK_WINNER_NUMBER_SENTENCE = "지난 주 당첨번호를 입력해 주세요.";
    private static final String ASK_BONUS_NUMBER_SENTENCE = "보너스 볼을 입력해 주세요.";

    private static Scanner scan = new Scanner(System.in);

    public static int inputPrice() {
        System.out.println(ASK_PRICE_SENTENCE);
        int price = scan.nextInt();
        scan.nextLine();
        return price;
    }

    public static int inputManualTicketCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int count = scan.nextInt();
        scan.nextLine();
        return count;
    }

    public static List<String> inputManualTickets(int count) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<String> rawNumbers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            rawNumbers.add(scan.nextLine());
        }
        return rawNumbers;
    }

    public static String inputManualTicket() {
        return scan.nextLine();
    }

    public static String inputWinnerNumbers() {
        System.out.println(ASK_WINNER_NUMBER_SENTENCE);
        String numbers = scan.nextLine();
        return numbers;
    }

    public static int inputBonusNumber() {
        System.out.println(ASK_BONUS_NUMBER_SENTENCE);
        int bonus = scan.nextInt();
        return bonus;
    }

}
