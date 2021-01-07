package lotto.view;

import java.util.Scanner;

public class InputView {
    public static Scanner scan = new Scanner(System.in);

    public static int getMoneyFromUser(){
        System.out.println("구입금액을 입력해 주세요.");
        int money = scan.nextInt();
        return money;
    }
}
