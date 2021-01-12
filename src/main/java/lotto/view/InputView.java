package lotto.view;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {
    public static final String PRICE_INPUT_TEXT = "구입금액을 입력해 주세요.";
    public static final String SELF_LOTTO_COUNT_TEXT = "수동으로 구매할 로또 수를 입력해 주세요.";
    public static final String NUMBER_INPUT_TEXT = "지난 주 당첨 번호를 입력해 주세요.";
    public static final String BONUS_INPUT_TEXT = "보너스 볼을 입력해 주세요.";
    private static final String SPLIT_DELIMITER = ", ";
    private static final Scanner scanner = new Scanner(System.in);

    public static int getMoneyFromUser() {
        System.out.println(PRICE_INPUT_TEXT);
        return Integer.parseInt(scanner.nextLine());
    }

    public static int getSelfLottoCountFromUser() {
        System.out.println(SELF_LOTTO_COUNT_TEXT);
        return Integer.parseInt(scanner.nextLine());
    }

    public static List<Integer> getSelfLottoNumberFromUser() {
        return Stream.of(split(scanner.nextLine()))
                .map(InputView::getParseInt)
                .sorted()
                .collect(Collectors.toList());
    }

    public static List<Integer> getWinningNumberFromUser() {
        System.out.println(NUMBER_INPUT_TEXT);
        return Stream.of(split(scanner.nextLine()))
                .map(InputView::getParseInt)
                .sorted()
                .collect(Collectors.toList());
    }

    public static int getBonusNumberFromUser() {
        System.out.println(BONUS_INPUT_TEXT);
        return scanner.nextInt();
    }

    private static String[] split(String numbersText) {
        return numbersText.split(SPLIT_DELIMITER);
    }

    private static int getParseInt(String number) {
        return Integer.parseInt(number);
    }
}
