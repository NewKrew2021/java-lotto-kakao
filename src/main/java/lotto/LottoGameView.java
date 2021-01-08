package lotto;

import java.util.Scanner;

public class LottoGameView {

    private static Scanner scan = new Scanner(System.in);

    public static int inputPrice() {
        System.out.println("구입 금액을 입력해 주세요.");
        int price = scan.nextInt();
        scan.nextLine();
        return price;
    }

    public static void printLottoTickets(LottoTickets lottoTickets) {
        System.out.println(lottoTickets.getTicketCount() + "개를 구매했습니다.");
        System.out.println(lottoTickets);
    }

    public static String inputWinnerNumbers() {
        System.out.println("지난 주 당첨번호를 입력해 주세요.");
        String numbers = scan.nextLine();
        return numbers;
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonus = scan.nextInt();
        return bonus;
    }

    public static void printResult(LottoResults lottoResults, int price) {
        System.out.println("당첨 통계");
        System.out.println("--------------");
        System.out.println(lottoResults);
        System.out.println("총 수익률은 " + lottoResults.calculateRate(price) + " 입니다.");
    }

}
