package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    public static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String INPUT_WINNER_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_BALL_MESSAGE = "보너스 볼을 입력해 주세요.";
    public static final String REGEX = ",";

    public static int inputMoney() {
        System.out.println(INPUT_MONEY_MESSAGE);
        return Integer.parseInt(scanner.nextLine());
    }

    public static List<Integer> inputWinnerNumbers() {
        System.out.println(INPUT_WINNER_NUMBERS_MESSAGE);
        String winnerNumbers = scanner.nextLine();
        return Arrays.stream(winnerNumbers.split(REGEX))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int inputBonusNumber() {
        System.out.println(INPUT_BONUS_BALL_MESSAGE);
        return Integer.parseInt(scanner.nextLine());
    }

}
