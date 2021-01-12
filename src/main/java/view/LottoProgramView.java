package view;

import domain.*;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoProgramView {

    public static final String BUY_AMOUNT_PHRASE = "구입금액을 입력해 주세요.";
    public static final String BUY_MANUAL_COUNT_PHRASE = "수동으로 구매할 로또 수를 입력해 주세요.";
    public static final String LOTTOS_BOUGHT_PHRASE = "개를 구매했습니다.";
    public static final String LAST_WEEK_BALLS_PHRASE = "\n지난 주 당첨 번호를 입력해 주세요.";
    public static final String BONUS_BALL_INPUT_PHRASE = "보너스 볼을 입력해 주세요";
    public static final String WINNING_STATISTICS_PHRASE = "당첨 통계\n---------";

    private Scanner scanner;

    public LottoProgramView() {
        scanner = new Scanner(System.in);
    }

    public int getBuyAmountForUser() {
        System.out.println(BUY_AMOUNT_PHRASE);
        String buyAmount = scanner.nextLine();
        if (!checkNumberFormat(buyAmount)) {
            throw new InputMismatchException("입력 값은 숫자이어야 합니다.");
        }
        return Integer.parseInt(buyAmount);
    }

    public int getBuyManualLottoCountForUser(){
        System.out.println(BUY_MANUAL_COUNT_PHRASE);
        String buyManualAccount = scanner.nextLine();
        if (!checkNumberFormat(buyManualAccount)) {
            throw new InputMismatchException("입력 값은 숫자이어야 합니다.");
        }
        return Integer.parseInt(buyManualAccount);
    }

    public boolean checkNumberFormat(String buyAmount) {
        return buyAmount.chars().allMatch(Character::isDigit);
    }

    public void printBoughtLottosCount(int count) {
        StringBuilder printBuilder = new StringBuilder();

        printBuilder.append(count);
        printBuilder.append(LOTTOS_BOUGHT_PHRASE);

        System.out.println(printBuilder.toString());
    }

    public void printLottosNumber(AutoLottos autoLottos) {
        for (Lotto lotto : autoLottos.getLottos()) {
            System.out.println(lotto.toString());
        }
    }

    public int getBonusBallForUser(){
        System.out.println(BONUS_BALL_INPUT_PHRASE);
        return scanner.nextInt();
    }

    public List<Ball> getWinningLottoForUser() {
        System.out.println(LAST_WEEK_BALLS_PHRASE);
        return Arrays.stream(scanner.nextLine().split(","))
                .map(Ball::map)
                .collect(Collectors.toList());
    }

    public void printWinningStatistics(LottoStatistics statistics) {
        System.out.println(WINNING_STATISTICS_PHRASE);
        System.out.println(statistics.toString());
    }

}