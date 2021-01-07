package lotto.ui;

import lotto.domain.Lottery;
import lotto.domain.LotteryAnswer;
import lotto.domain.LotteryNumber;
import lotto.domain.LotteryUtil;

import java.util.Scanner;

/*
  - [ ] 1.1 구입금액 입력받는 UI 구현
로또 1장의 가격은 1000원이다.
구입금액을 입력해 주세요.
14000

  - [ ] 1.2 지난 주 당첨 번호, 보너스 볼 입력 UI 구현
지난 주 당첨 번호를 입력해 주세요.
1, 2, 3, 4, 5, 6
보너스 볼을 입력해 주세요.
7

 */
public class InputView {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        printReadMoneyHelp();
        readMoney();
        readLotteryAnswer();
    }

    public static void printReadMoneyHelp(){
        System.out.println("로또 1장의 가격은 1000원이다.");
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static int readMoney(){
        try{
            return Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e){
            System.out.println("돈을 올바른 형태로 입력해주세요 ex) 10000");
            return readMoney();
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("알수 없는 오류가 발생했습니다. 관리자에게 문의해주세요");
            return -1;
        }
    }

    public static LotteryAnswer readLotteryAnswer(){
        try {
            Lottery numbers = getAnswerLotteryNumbers();
            LotteryNumber bonusBallNumber = getAnswerBonusNumber();
            return new LotteryAnswer(numbers, bonusBallNumber);
        } catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return readLotteryAnswer();
        }
    }

    private static Lottery getAnswerLotteryNumbers() {
        System.out.println("지난주 당첨번호를 입력해주세요.");
        return LotteryUtil.convertStringsToLottery(sc.nextLine().split(","));
    }

    private static LotteryNumber getAnswerBonusNumber() {
        System.out.println("보너스 볼 번호를 입력해주세요.");
        return new LotteryNumber(Integer.parseInt(sc.nextLine().trim()));
    }
}
