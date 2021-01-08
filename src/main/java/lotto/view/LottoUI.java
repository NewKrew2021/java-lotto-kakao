package lotto.view;

import lotto.domain.Lottos;

import java.util.Scanner;

public class LottoUI {
    private static Scanner scanner;

    public LottoUI() {
        scanner = new Scanner(System.in);
    }

    public static int getMoneyFromUser() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public static void printLottos(Lottos lottos) {
        System.out.println(lottos.getNumOfLotto() + "개를 구매했습니다.");
        System.out.println(lottos);
    }

    public static String getWinningNumberFromUser() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        scanner.nextLine();
        return scanner.nextLine();
    }

    public static int getBonusNumberFromUser() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextInt();
    }

    public static void printStatistics(String statisticsText, int profitRate) {
        System.out.println("당첨 통계\n---------");
        System.out.println(statisticsText);
        System.out.printf("총 수익률은 %d%% 입니다.\n", profitRate);
    }
}
