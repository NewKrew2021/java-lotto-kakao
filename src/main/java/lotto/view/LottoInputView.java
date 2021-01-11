package lotto.view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class LottoInputView {

    private final static Scanner scanner = new Scanner(System.in);

    public static int inputPurchaseMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return inputInteger();
    }

    public static int inputManualLottoAmount() {
        System.out.println("\n수동으로 구매할 로또 수를 입력해 주세요.");
        return inputInteger();
    }

    private static int inputInteger() {
        int integerValue = 0;
        try {
            integerValue = scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("정수를 입력해야합니다.");
        }
        return integerValue;
    }

    public static List<String> inputManualLottoStrings(int amount) {
        scanner.nextLine();
        if(amount == 0){
            return new ArrayList<>();
        }
        System.out.println("\n수동으로 구매할 번호를 입력해 주세요.");
        List<String> manualLottoStrings = new ArrayList<>();
        for (int i = 0; i < amount; ++i){
            manualLottoStrings.add(scanner.nextLine());
        }
        return manualLottoStrings;
    }

    public static String inputWinningLotto() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public static String inputBonusBall() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.next();
    }
}