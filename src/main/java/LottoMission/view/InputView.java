package LottoMission.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    static Scanner scanner;

    public static int enterUerMoney(){
        scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public static List<Integer> enterLastWeekWinningNumbers(){
        scanner = new Scanner(System.in);
        System.out.println("지난 주 담첨 번호를 입력해 주세요.");
        String str = scanner.nextLine();
        String[] strArr = str.split(",");
        System.out.println(str);
        List<Integer> winningNumbers = new ArrayList<>();
        for (String s : strArr) {
            s = s.trim();
            Integer parseInt = Integer.parseInt(s);
            winningNumbers.add(parseInt);
        }
        return winningNumbers;
    }

    public static int enterLastWeekBonusNumber(){
        scanner = new Scanner(System.in);
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextInt();
    }
}
