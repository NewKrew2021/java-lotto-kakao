package lotto.ui;

import lotto.domain.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);

    public static int readMoney() {
        try {
            System.out.printf("로또 1장의 가격은 %d입니다.\n", LotteryUtil.LOTTERY_PRICE);
            System.out.println("구입금액을 입력해 주세요.");
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
            System.out.println("지난 주 당첨번호를 입력해주세요.");
            Lottery numbers = getLotteryNumbers();
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

    public static int readManualLotteryCount(int maxCount) {
        try {
            System.out.printf("수동으로 구매할 로또 수를 입력해 주세요. (최대 : %d)\n", maxCount);
            int count = Integer.parseInt(sc.nextLine().trim());
            if(count > maxCount || count < 0){
                throw new OutOfRangeException("유효하지 않은 수 범위입니다");
            }
            return count;
        } catch (NumberFormatException e) {
            System.out.println("수을 올바른 형태로 입력해주세요 ex) 9");
            return readManualLotteryCount(maxCount);
        } catch (OutOfRangeException e) {
            System.out.println("구매 수량 이내의 수를 입력해 주세요 ex) 5");
            return readManualLotteryCount(maxCount);
        } catch (Exception e) {
            handleUnknownError(e);
            return -1;
        }
    }

    public static List<Lottery> readLotteries(int manualLotteryCount) {
        List<Lottery> lotteries = new ArrayList<>();
        if(manualLotteryCount == 0){
            return lotteries;
        }
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        for (int i = 0; i < manualLotteryCount; i++) {
            lotteries.add(getLotteryNumbers());
        }
        return lotteries;
    }

    public static Lotteries getLotteries(int lotteryCount) {
        int manualLotteryCount = readManualLotteryCount(lotteryCount);
        int randomLotteryCount = lotteryCount - manualLotteryCount;
        List<Lottery> lotteries = readLotteries(manualLotteryCount);
        lotteries.addAll(Lotteries.getRandomLotteryList(randomLotteryCount));
        return new Lotteries(lotteries);
    }

    private static Lottery getLotteryNumbers() {
        try {
            return LotteryUtil.convertStringsToLottery(sc.nextLine().split(","));
        } catch(NumberFormatException e){
            System.out.println(", 로 구분하여 수를 입력해 주시기 바랍니다");
            return getLotteryNumbers();
        } catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return getLotteryNumbers();
        } catch(Exception e){
            handleUnknownError(e); // 시스템 종료 함수
            return null;
        }
    }

    private static LotteryNumber getAnswerBonusNumber() {
        System.out.println("보너스 볼 번호를 입력해주세요.");
        try {
            return LotteryNumber.of(Integer.parseInt(sc.nextLine().trim()));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정상적인 정수 포맷을 입력하세요.");
        }
    }

    private static void handleUnknownError(Exception e) {
        e.printStackTrace();
        System.out.println("알 수 없는 오류가 발생했습니다. 관리자에게 문의해주세요");
        System.exit(1);
    }

    private static class OutOfRangeException extends IllegalArgumentException{
        OutOfRangeException(String e){
            super(e);
        }
    }
}
