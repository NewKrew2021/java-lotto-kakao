package view;

import dto.LottoTicketCount;
import dto.Amount;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoInputView {

    private static Scanner sc = new Scanner(System.in);

    public static Amount inputAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return new Amount(Integer.parseInt(sc.nextLine()));
    }

    public static List<Integer> inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return getLottoNumbers();
    }

    public static List<List<Integer>> inputLottoNumbers(LottoTicketCount ticketCount){
        System.out.println("수동으로 구매할 번호를 입력해주세요.");
        List<List<Integer>> numbers = new ArrayList<>();
        for (int i = 0; i < ticketCount.getLottoTicketCount(); i++) {
            numbers.add(getLottoNumbers());
        }
        return numbers;
    }

    public static List<Integer> getLottoNumbers(){
        return Arrays.stream(sc.nextLine().split(","))
                .map(i->Integer.parseInt(i))
                .collect(Collectors.toList());
    }


    public static int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return Integer.parseInt(sc.nextLine());
    }

    public static LottoTicketCount inputManualCount(Amount amount) {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return new LottoTicketCount(Integer.parseInt(sc.nextLine()), amount.getCount());
    }
}
