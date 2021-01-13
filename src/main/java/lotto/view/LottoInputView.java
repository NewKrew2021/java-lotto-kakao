package lotto.view;

import lotto.domain.LottoNo;
import lotto.domain.LottoTicket;
import lotto.domain.Money;
import java.util.*;
import java.util.stream.Collectors;

public class LottoInputView {

    private static Scanner sc = new Scanner(System.in);

    public static int inputMoney() {
        String money;

        do {
            System.out.println("구입금액을 입력해 주세요.");
            money = sc.nextLine();
        } while(!validateMoney(money));

        return Integer.parseInt(money);
    }

    private static boolean validateMoney(String inputMoney) {
        int money = convertStringToIntMoney(inputMoney);
        if( !Money.validateInputMoney(money) ) {
            System.out.println("잘못된 금액을 입력하셨습니다.");
            return false;
        }
        return true;
    }

    private static Integer convertStringToIntMoney(String inputMoney) {
        try {
            return Integer.parseInt(inputMoney);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static Set<Integer> inputWinningNumbers() {
        Set<Integer> nums;
        do{
            System.out.println("지난 주 당첨 번호를 입력해 주세요.");
            nums = convertInputToNumbers(sc.nextLine().split(", "));
        }while(!validateWinningNumber(nums));
        return nums;
    }

    private static Set<Integer> convertInputToNumbers(String[] inputString) {
        try {
            return Arrays.stream(inputString)
                    .map(Integer::parseInt)
                    .collect(Collectors.toSet());
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return new HashSet<>();
    }

    private static boolean validateWinningNumber(Set<Integer> numbers){
        if( !LottoTicket.validateLottoTicket(numbers) ) {
            System.out.println("당첨번호가 적절하지 않습니다.");
            return false;
        }

        return true;
    }

    public static int inputBonusNumber() {
        String bonusNum;
        do{
            System.out.println("보너스 볼을 입력해 주세요.");
            bonusNum = sc.nextLine();
        }while(!validateBonusNumber(bonusNum));
        System.out.println();
        return Integer.parseInt(bonusNum);
    }

    private static boolean validateBonusNumber(String inputBonus){
        int bonusNum = convertStringToIntMoney(inputBonus);
        if( !LottoNo.validateLottoNo(bonusNum) ) {
            System.out.println("보너스볼 번호가 적절하지 않습니다.");
            return false;
        }

        return true;
    }
}
