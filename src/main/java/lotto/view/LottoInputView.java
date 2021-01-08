package lotto.view;

import lotto.domain.LottoNo;
import lotto.domain.LottoNos;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LottoInputView {
    private static Scanner sc;
    private static final int LOTTO_PRICE = 1000;
    static {
        sc = new Scanner(System.in);
    }

    public int getLottoCountFromUser() {
        System.out.println("구입금액을 입력해 주세요.");
        int count = new Scanner(System.in).nextInt() / LOTTO_PRICE;
        while (count <= 0) {
            System.out.println("구입금액을 잘못 입력하셨습니다. 다시 입력해주세요.");
            count = sc.nextInt() / LOTTO_PRICE;
        }
        return count;
    }

    public List<Integer> inputWinningNumbers() {
        List<Integer> nums;
        do{
            System.out.println("지난 주 당첨 번호를 입력해 주세요.");
            nums = Arrays.stream(sc.nextLine().split(", "))
                    .map((num) -> Integer.parseInt(num))
                    .collect(Collectors.toList());
        }while(!checkValidWinningNumber(nums));
        return nums;
    }

    private boolean checkValidWinningNumber(List<Integer> nums){
        try{
            LottoNos lottoNos = new LottoNos(nums);
        } catch (Exception e){
            System.out.println("당첨번호가 적절하지 않습니다.");
            return false;
        }
        return true;
    }

    public int inputBonusNumber() {
        int bonusNum;
        do{
            System.out.println("보너스 볼을 입력해 주세요.");
            bonusNum = sc.nextInt();
        }while(!checkValidBonusNumber(bonusNum));
        return bonusNum;
    }

    private boolean checkValidBonusNumber(int bonusNum){
        try{
            LottoNo lottoNo = new LottoNo(bonusNum);
        } catch (Exception e){
            System.out.println("보너스볼 번호가 적절하지 않습니다.");
            return false;
        }
        return true;
    }
}
