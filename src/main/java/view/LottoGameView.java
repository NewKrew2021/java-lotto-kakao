package view;

import java.util.Scanner;

public class LottoGameView {
    private static final Scanner sc = new Scanner(System.in);

    public static int getInt() {
        int num = sc.nextInt();
        sc.nextLine();
        return num;
    }

    public static String getStringLine() {
        return sc.nextLine();
    }

    public static void print(String str) {
        System.out.println(str);
    }

    public static void startMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void countTicket(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void insertWinnerNumber(){
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    }

    public static void insertBonus(){
        System.out.println("보너스 볼을 입력해 주세요.");
    }

    public static void result(String resultString){
        System.out.println("\n" + "당첨 통계");
        System.out.println("----------");
        System.out.println(resultString);
    }
}
