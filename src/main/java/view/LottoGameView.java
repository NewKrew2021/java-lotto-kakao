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

    public static void insertLotto() {
        System.out.println("\n" + INSERT_LOTTO_COUNT);
    }

    public static void insertLottoNumbers() {
        System.out.println("\n" + INSERT_LOTTO_NUMBERS);
    }

    public static void ticketCount(int manualTicketCount, int autoTicketCount) {
        System.out.println("\n수동으로 " + manualTicketCount + "장, 자동으로 " + autoTicketCount + "개를 구매했습니다.");
    }
}
