package lotto.view;

import lotto.domain.PurchaseMoney;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoInputView {
    public static final String ASK_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String ASK_MANUAL_QUANTITY_MESSAGE = "\n수동으로 구매할 로또 수를 입력해 주세요.";
    public static final String ASK_MANUAL_NUMBER_MESSAGE = "\n수동으로 구매할 번호를 입력해 주세요.\n";
    public static final String ASK_WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    public static final String ASK_BONUS_BALL_MESSAGE = "보너스 볼을 입력해 주세요.";
    private final static Scanner scanner = new Scanner(System.in);

    public static String inputPurchaseMoney() {
        System.out.println(ASK_MONEY_MESSAGE);
        return scanner.next();
    }

    public static List<String> inputLottoTexts(PurchaseMoney purchaseMoney) {
        System.out.println(ASK_MANUAL_QUANTITY_MESSAGE);
        int manualQuantity = scanner.nextInt();
        purchaseMoney.checkManualQuantity(manualQuantity);
        System.out.print(manualQuantity > 0 ? ASK_MANUAL_NUMBER_MESSAGE : "");
        scanner.nextLine();

        return IntStream.range(0, manualQuantity)
                .mapToObj(value -> scanner.nextLine())
                .collect(Collectors.toList());
    }

    public static String inputWinningLotto() {
        System.out.println(ASK_WINNING_NUMBER_MESSAGE);
        return scanner.nextLine();
    }

    public static String inputBonusBall() {
        System.out.println(ASK_BONUS_BALL_MESSAGE);
        return scanner.next();
    }
}