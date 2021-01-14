package lotto.view;

import lotto.domain.Amount;
import lotto.domain.LottoNumber;

import java.util.Scanner;

public class LottoInputView {
    private final Scanner scanner;
    private final String INPUT_MONEY_PHRASE = "구입금액을 입력해주세요.";
    private final String INPUT_WONLOTTO_PHRASE = "지난 주 당첨 번호를 입력해주세요.";
    private final String INPUT_BONUS_BALL_PHRASE = "보너스 볼을 입력해주세요.";
    private final String INPUT_QUANTITY_PHRASE = "수동으로 %d장, 자동으로 %d개를 구매했습니다.";
    private final String INPUT_MANUAL_LOTTO_NUMBER_PHRASE = "수동으로 구매할 번호를 입력해 주세요.";
    private final String INPUT_MANUAL_LOTTO_COUNT_PHRASE = "수동으로 구매할 로또 수를 입력해 주세요.";


    public LottoInputView() {
        scanner = new Scanner(System.in);
    }

    public String getWonLotto() {
        System.out.println(INPUT_WONLOTTO_PHRASE);
        return scanner.nextLine();
    }

    public int getBonusBall() {
        System.out.println(INPUT_BONUS_BALL_PHRASE);
        int bonusBall = scanner.nextInt();
        scanner.nextLine();
        return bonusBall;
    }

    public int getLottoBuyAmount() {
        System.out.println(INPUT_MONEY_PHRASE);
        try {
            int money = scanner.nextInt();
            scanner.nextLine();
            return money;
        } catch (Exception e) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }

    public int getManualLottoAmount(){
        System.out.println(INPUT_MANUAL_LOTTO_COUNT_PHRASE);
        try {
            int amount = scanner.nextInt();
            scanner.nextLine();
            return amount;
        } catch (Exception e) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
    }
    public String getManualLottoNumber(){
        return scanner.nextLine();
    }

    public void printInputQuantityPhrase(Amount amount) {
        System.out.println(String.format(INPUT_QUANTITY_PHRASE,amount.manualCount(),amount.autoCount()));
    }
    public void printInputManualLottoNumberPhrase() {
        System.out.println(INPUT_MANUAL_LOTTO_NUMBER_PHRASE);
    }

}
