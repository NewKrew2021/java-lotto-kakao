package lotto.view;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class InputView {
    public static Scanner scan = new Scanner(System.in);

    public static int getMoneyFromUser(){
        System.out.println("구입금액을 입력해 주세요.");
        int money = scan.nextInt();
        return money;
    }

    public static Set<Integer> getWinnerNumber(){
        System.out.println("지난 주 당첨 번호를 입력해 주세요");
        String beforeSplit = scan.nextLine();
        String[] splitedNumbers = beforeSplit.split(",");
        Set<Integer> numbers = new HashSet<>();
        for (String splitedNumber : splitedNumbers) {
            numbers.add(Integer.parseInt(splitedNumber.trim()));
        }
        return numbers;
    }

    public static int getBonusBall() {
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonus = scan.nextInt();
        return bonus;
    }
}
