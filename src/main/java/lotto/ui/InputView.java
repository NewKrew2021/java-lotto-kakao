package lotto.ui;

import lotto.domain.Lottery;
import lotto.domain.LotteryAnswer;
import lotto.domain.LotteryNumber;
import lotto.domain.LotteryUtil;

import java.util.Scanner;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);

    public static int readMoney() {
        try {
            printReadMoneyHelp();
            return Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("돈을 올바른 형태로 입력해주세요 ex) 10000");
            return readMoney();
        } catch (Exception e) {
            handleUnknownError(e);
            return -1;
        }
    }

    public static LotteryAnswer readLotteryAnswer() {
        try {
            Lottery numbers = getAnswerLotteryNumbers();
            LotteryNumber bonusBallNumber = getAnswerBonusNumber();
            return new LotteryAnswer(numbers, bonusBallNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readLotteryAnswer();
        } catch (Exception e) {
            handleUnknownError(e);
            return null;
        }
    }

    private static void printReadMoneyHelp() {
        System.out.println("로또 1장의 가격은 1000원이다.");
        System.out.println("구입금액을 입력해 주세요.");
    }

    private static Lottery getAnswerLotteryNumbers() {
        System.out.println("지난주 당첨번호를 입력해주세요.");
        return LotteryUtil.convertStringsToLottery(sc.nextLine().split(","));
    }

    private static LotteryNumber getAnswerBonusNumber() {
        System.out.println("보너스 볼 번호를 입력해주세요.");
        int lotteryNumber;
        try {
            lotteryNumber = Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정상적인 정수 포맷을 입력하세요.");
        }
        return new LotteryNumber(lotteryNumber);

    }

    private static void handleUnknownError(Exception e) {
        e.printStackTrace();
        System.out.println("알 수 없는 오류가 발생했습니다. 관리자에게 문의해주세요");
        System.exit(1);
    }
}
