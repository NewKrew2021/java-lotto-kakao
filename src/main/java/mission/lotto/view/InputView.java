package mission.lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {

    private static final String userMoneyMessage = "구입금액을 입력해 주세요.";
    private static final String manualCountMessage = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String manualListMessage = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String lastAnswerMessage = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String bonusBallMessage = "보너스 볼을 입력해 주세요.";

    private static Scanner scanner;

    public static int enterUerMoney() {
        System.out.println(userMoneyMessage);
        scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static List<Integer> enterLastWeekWinningNumbers() {
        System.out.println(lastAnswerMessage);
        return getIntegerList();
    }

    public static int enterLastWeekBonusNumber() {
        System.out.println(bonusBallMessage);
        scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static int enterManualCount() {
        System.out.println(manualCountMessage);
        scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static List<List<Integer>> enterManualList(int manualCount) {
        System.out.println(manualListMessage);
        return IntStream.range(0, manualCount)
                .mapToObj(value -> getIntegerList())
                .collect(Collectors.toList());
    }

    private static List<Integer> getIntegerList() {
        scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] strArr = str.split(",");
        List<Integer> winningNumbers = new ArrayList<>();
        for (String s : strArr) {
            s = s.trim();
            Integer parseInt = Integer.parseInt(s);
            winningNumbers.add(parseInt);
        }
        return winningNumbers;
    }
}
