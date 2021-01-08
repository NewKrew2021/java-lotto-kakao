package lotto.view;

import java.util.Scanner;

public class LottoInputView {
    private Scanner scanner;

    public LottoInputView(){
        scanner = new Scanner(System.in);
    }

    public int getLottoBuyAmount(){
        int amount = Integer.parseInt(scanner.nextLine());
        return amount;
    }

    public String getWonLotto(){
        String wonLotto = scanner.nextLine();
        return wonLotto;
    }

    public int getBonusBall(){
        int bonusBall = Integer.parseInt(scanner.nextLine());
        return bonusBall;
    }
}
