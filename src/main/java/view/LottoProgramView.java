package view;

import domain.Lotto;
import domain.LottoStatistics;
import domain.Lottos;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoProgramView {

    private Scanner scanner;

    public static final String BUY_AMOUNT_PHRASE = "구입금액을 입력해 주세요.";
    public static final String LOTTOS_BOUGHT_PHRASE = "개를 구매했습니다.";
    public static final String LAST_WEEK_BALLS_PHRASE = "\n지난 주 당첨 번호를 입력해 주세요.";
    public static final String BONUS_BALL_INPUT_PHRASE= "보너스 볼을 입력해 주세요";
    public static final String WINNING_STATISTICS_PHRASE = "당첨 통계\n---------";

    public LottoProgramView(){
        scanner = new Scanner(System.in);
    }

    public BigDecimal getBuyAmountForUser(){
        System.out.println(BUY_AMOUNT_PHRASE);
        String buyAmount = scanner.nextLine();
        if(!checkNumberFormat(buyAmount)){
            throw new InputMismatchException("입력 값은 숫자이어야 합니다.");
        }
        return new BigDecimal(buyAmount);
    }

    public boolean checkNumberFormat(String buyAmount) {
        return buyAmount.chars().allMatch(Character::isDigit);
    }

    public void printBoughtLottosCount(int count){
        StringBuilder printBuilder = new StringBuilder();

        printBuilder.append(count);
        printBuilder.append(LOTTOS_BOUGHT_PHRASE);

        System.out.println(printBuilder.toString());
    }

    public void printLottosNumber(Lottos lottos){
        for(Lotto lotto : lottos.getLottos()){
            System.out.println(lotto.toString());
        }
    }

    public Lotto getWinningLotto(){
        System.out.println(LAST_WEEK_BALLS_PHRASE);
        List<Integer> balls = Arrays.stream(scanner.nextLine().split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());

        System.out.println(BONUS_BALL_INPUT_PHRASE);
        String bonusBall = scanner.nextLine();

        if(!checkNumberFormat(bonusBall)){
            throw new InputMismatchException("입력 값은 숫자이어야 합니다.");
        }

        return new Lotto(balls,Integer.parseInt(bonusBall));
    }

    public void printWinningStatistics(LottoStatistics statistics){
        System.out.println(WINNING_STATISTICS_PHRASE);
        System.out.println(statistics.toString());
    }

}
