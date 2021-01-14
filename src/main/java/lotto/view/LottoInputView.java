package lotto.view;

import lotto.domain.Amount;
import lotto.domain.LottoNumber;

import java.util.Scanner;

public class LottoInputView {
    private final Scanner scanner;
    private final String INPUT_MONEY_PHRASE = "구입금액을 입력해주세요.";
    private final String INPUT_WONLOTTO_PHRASE = "지난 주 당첨 번호를 입력해주세요.";
    private final String INPUT_BONUS_BALL_PHRASE = "보너스 볼을 입력해주세요.";
    private final String INPUT_QUANTITY_PHRASE = "개를 구매했습니다.";

    public LottoInputView() {
        scanner = new Scanner(System.in);
    }

    public String getWonLotto() {
        System.out.println(INPUT_WONLOTTO_PHRASE);
        return scanner.nextLine();
    }

    public LottoNumber getBonusBall() {
        System.out.println(INPUT_BONUS_BALL_PHRASE);
        int bonusBall = scanner.nextInt();
        scanner.nextLine();
        return LottoNumber.of(bonusBall);
    }

    public Amount getLottoBuyAmount() {
        System.out.println(INPUT_MONEY_PHRASE);
        try {
            int money = scanner.nextInt();
            scanner.nextLine();
            return new Amount(money);
        } catch (Exception e) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    public void printInputQuantityPhrase(int quantity) {
        System.out.println(quantity + INPUT_QUANTITY_PHRASE);
    }
}
