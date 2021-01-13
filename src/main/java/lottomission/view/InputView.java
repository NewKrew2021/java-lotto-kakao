package lottomission.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {

    static Scanner scanner;

    public static int enterUerMoney() {
        scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public static int enterSelfLottoCount(){
        scanner = new Scanner(System.in);
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return scanner.nextInt();
    }

    public static List<List<Integer>> enterSelfLottoNumbers(int count){
        scanner = new Scanner(System.in);
        System.out.println("수동으로 구매할 번호를 입력해 주세요");
        return IntStream.range(0, count)
                .mapToObj(i -> scanner.nextLine().split(","))
                .map(strArr -> Arrays
                .stream(strArr)
                .map(s -> Integer.parseInt(s.trim()))
                .collect(Collectors.toList()))
                .collect(Collectors.toList());
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
