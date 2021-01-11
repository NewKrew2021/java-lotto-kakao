package lotto.ui;

import lotto.domain.*;
import lotto.exception.InvalidLotteryNumberException;

import java.util.Scanner;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);

    public static Money readMoney() {
        try {
            Money money = new Money(Integer.parseInt(sc.nextLine().trim()));
            System.out.printf("%d개를 구매했습니다", Money.calculateLotteryCount(money));
            System.out.println();
            return money;
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return readMoney();
        } catch (Exception e) {
            handleUnknownError(e);
            return null;
        }
    }

    public static int readManualLotteryCount() {
        try {
            System.out.println("수동으로 구매할 로또 갯수를 입력해 주세요.");
            return Integer.parseInt(sc.nextLine().trim());
        } catch (IllegalArgumentException e) {
            System.out.println("숫자로 입력해주세요.");
            return readManualLotteryCount();
        }
    }

    public static Lotteries readManualLotteries(int count) {
        Lotteries lotteries = new Lotteries();
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        for (int i = 0; i < count; i++) {
            String[] lotteryNumbers = sc.nextLine().split(",");
            lotteries.push(new Lottery(lotteryNumbers));
        }
        return lotteries;
    }

    public static LotteryAnswer readLotteryAnswer() {
        try {
            Lottery numbers = getAnswerLotteryNumbers();
            LotteryNumber bonusBallNumber = getAnswerBonusNumber();
            return new LotteryAnswer(numbers, bonusBallNumber);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return readLotteryAnswer();
        } catch (Exception e) {
            handleUnknownError(e);
            return null;
        }
    }

    private static Lottery getAnswerLotteryNumbers() {
        System.out.println("지난주 당첨번호를 입력해주세요.");
        return new Lottery(sc.nextLine().split(","));
    }

    private static LotteryNumber getAnswerBonusNumber() {
        System.out.println("보너스 볼 번호를 입력해주세요.");
        try {
            int lotteryNumber = Integer.parseInt(sc.nextLine().trim());
            return new LotteryNumber(lotteryNumber);
        } catch (NumberFormatException e) {
            throw new InvalidLotteryNumberException();
        }
    }

    private static void handleUnknownError(Exception e) {
        e.printStackTrace();
        System.out.println("알 수 없는 오류가 발생했습니다. 관리자에게 문의해주세요");
        System.exit(1);
    }
}
