package lottoMission.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    static Scanner scanner;

    public static int enterUerMoney() {
        scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public static List<Integer> enterLastWeekWinningNumbers() {
        scanner = new Scanner(System.in);
        System.out.println("지난 주 담첨 번호를 입력해 주세요.");
        String str = scanner.nextLine();
        String[] strArr = str.split(",");
        return Arrays
                .stream(strArr)
                .map(s -> Integer.parseInt(s.trim()))
                .collect(Collectors.toList());
    }

    public static int enterLastWeekBonusNumber() {
        scanner = new Scanner(System.in);
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextInt();
    }
}
