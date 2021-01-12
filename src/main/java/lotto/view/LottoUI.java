package lotto.view;

import lotto.dto.LottosDto;
import lotto.dto.RankingsDto;
import lotto.util.Rank;

import java.util.Scanner;

public class LottoUI {
    private final Scanner scanner;

    public LottoUI() {
        scanner = new Scanner(System.in);
    }

    public int getMoneyFromUser() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public int getNumOfManualFromUser() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public void printManualLottoMessage() {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
    }

    public String getManualLottoFromUser() {
        return scanner.nextLine();
    }

    public void printLottosMessage(int numOfManual, int numOfAuto) {
        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.\n", numOfManual, numOfAuto);
    }

    public void printLottos(LottosDto lottosDto) {
        System.out.println(lottosDto);
    }

    public String getWinningNumberFromUser() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public int getBonusNumberFromUser() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public void printStatistics(RankingsDto rankingsDto) {
        System.out.println("당첨 통계\n---------");
        System.out.printf("3개 일치 (5000원)- %d개\n", rankingsDto.getRankings().get(Rank.FIFTH));
        System.out.printf("4개 일치 (50000원)- %d개\n",  rankingsDto.getRankings().get(Rank.FOURTH));
        System.out.printf("5개 일치 (1500000원)- %d개\n",  rankingsDto.getRankings().get(Rank.THIRD));
        System.out.printf("5개 일치, 보너스 볼 일치(30000000원)- %d개\n",  rankingsDto.getRankings().get(Rank.SECOND));
        System.out.printf("6개 일치 (2000000000원)- %d개\n",  rankingsDto.getRankings().get(Rank.FIRST));
    }

    public void printProfitRate(int profitRate) {
        System.out.printf("총 수익률은 %d%% 입니다.\n", profitRate);
    }
}
