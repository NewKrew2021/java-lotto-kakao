package view;

import java.util.Scanner;

import static domain.LottoConstant.*;

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
        System.out.println(INSERT_PRICE);
    }

    public static void countTicket(int count) {
        System.out.println(count + BUYING);
    }

    public static void insertWinnerNumber() {
        System.out.println(INSERT_WINNER_NUMBER);
    }

    public static void insertBonus() {
        System.out.println(INSERT_BONUS);
    }

    public static void result(String resultString) {
        System.out.println("\n" + WINNING_STATISTICS);
        System.out.println(SEPARATOR);
        System.out.println(resultString);
    }
}
