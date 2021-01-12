package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int readMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public static List<Integer> readWinningLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String input = scanner.nextLine();
        List<Integer> winningNumbers = Arrays.stream(input.split(", "))
                .map(Integer::valueOf)
                .collect(Collectors.toList());

        return winningNumbers;
    }

    public static int readBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusNumber = Integer.parseInt(scanner.nextLine());

        return bonusNumber;
    }

    public static int readNumberOfManualLottos() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");

        return Integer.parseInt(scanner.nextLine());
    }

    public static List<Integer> readLottoNumbers() {
        String input = scanner.nextLine();
        List<Integer> lottoNumbers = Arrays.stream(input.split(", "))
                .map(Integer::valueOf)
                .collect(Collectors.toList());

        return lottoNumbers;
    }
}
