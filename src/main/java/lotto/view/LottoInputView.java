package lotto.view;

import lotto.domain.LottoNo;
import lotto.domain.LottoTicket;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoInputView {
    private static Scanner sc = new Scanner(System.in);

    private static final int LOTTO_PRICE = 1000;

    public static int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        int count = Integer.parseInt(sc.nextLine()) / LOTTO_PRICE;
        while (count <= 0) {
            System.out.println("구입금액을 잘못 입력하셨습니다. 다시 입력해주세요.");
            count = Integer.parseInt(sc.nextLine()) / LOTTO_PRICE;
        }
        return count;
    }

    public static List<Integer> inputWinningNumbers() {
        List<Integer> nums;
        do{
            System.out.println("지난 주 당첨 번호를 입력해 주세요.");
            nums = convertInputToNumbers(sc.nextLine().split(", "));
        }while(!checkValidWinningNumber(nums));
        return nums;
    }

    private static List<Integer> convertInputToNumbers(String[] inputString) {
        try {
            return Arrays.stream(inputString)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return new ArrayList<>();
    }

    private static boolean checkValidWinningNumber(List<Integer> nums){
        try{
            LottoTicket lottoTicket = new LottoTicket(nums);
        } catch (Exception e){
            System.out.println("당첨번호가 적절하지 않습니다.");
            return false;
        }
        return true;
    }

    public static int inputBonusNumber() {
        int bonusNum;
        do{
            System.out.println("보너스 볼을 입력해 주세요.");
            bonusNum = sc.nextInt();
        }while(!checkValidBonusNumber(bonusNum));
        System.out.println();
        return bonusNum;
    }

    private static boolean checkValidBonusNumber(int bonusNum){
        try{
            LottoNo lottoNo = new LottoNo(bonusNum);
        } catch (Exception e){
            System.out.println("보너스볼 번호가 적절하지 않습니다.");
            return false;
        }
        return true;
    }
}
