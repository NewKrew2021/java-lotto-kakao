package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public static int inputManualTicketCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public static List<Integer> inputLottoNumbers() {
        System.out.println("수동으로 구매할 번호를 입력해주세요.");
        return getLottoNumbers();
    }

    public static List<Integer> inputWinnerNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return getLottoNumbers();
    }

    private static List<Integer> getLottoNumbers() {
        String numbers = scanner.nextLine();
        return Arrays.stream(numbers.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }
}
