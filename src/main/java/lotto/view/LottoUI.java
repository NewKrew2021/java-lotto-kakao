package lotto.view;

import lotto.domain.Lottos;

import java.util.Scanner;

public class LottoUI {
    public static final String PRICE_INPUT_TEXT = "구입금액을 입력해 주세요.";
    public static final String BUY_SUCCESS_TEXT = "개를 구매했습니다.";
    public static final String NUMBER_INPUT_TEXT = "지난 주 당첨 번호를 입력해 주세요.";
    public static final String BONUS_INPUT_TEXT = "보너스 볼을 입력해 주세요.";
    public static final String STATISTICS_LINE_TEXT = "당첨 통계\n---------";
    public static final String ALL_PROFIT_TEXT = "총 수익률은 %d%% 입니다.\n";
    private static Scanner scanner;

    public LottoUI() {
        scanner = new Scanner(System.in);
    }

    public static int getMoneyFromUser() {
        System.out.println(PRICE_INPUT_TEXT);
        return scanner.nextInt();
    }

    public static void printLottos(Lottos lottos) {
        System.out.println(lottos.getSizeOfLotto() + BUY_SUCCESS_TEXT);
        System.out.println(lottos);
    }

    public static String getWinningNumberFromUser() {
        System.out.println(NUMBER_INPUT_TEXT);
        scanner.nextLine();
        return scanner.nextLine();
    }

    public static int getBonusNumberFromUser() {
        System.out.println(BONUS_INPUT_TEXT);
        return scanner.nextInt();
    }

    public static void printStatistics(String statisticsText, int profitRate) {
        System.out.println(STATISTICS_LINE_TEXT);
        System.out.println(statisticsText);
        System.out.printf(ALL_PROFIT_TEXT, profitRate);
    }
}
