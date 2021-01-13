package lotto.view;

import lotto.domain.Amount;
import lotto.domain.LottoNumber;

import java.util.Scanner;

public class LottoInputView {

    private final Scanner scanner;

    public LottoInputView() {
        scanner = new Scanner(System.in);
    }

    public String getWonLotto() {

        return scanner.nextLine();
    }

    public LottoNumber getBonusBall() {

        int bonusBall = scanner.nextInt();
        return new LottoNumber(bonusBall);
    }


    public Amount getLottoBuyAmount() {

        try {
            int money = scanner.nextInt();
            return new Amount(money);
        } catch (Exception e) {
            System.out.println("잘못된 입력입니다.");
            return null;
        }
    }
}
