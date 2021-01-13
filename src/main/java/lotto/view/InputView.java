package lotto.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner input = new Scanner(System.in);

    public static int getPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        int price;

        try {
            price = Integer.parseInt(input.nextLine());
            System.out.println();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("금액 정보가 올바르지 않습니다.");
        }

        return price;
    }

    public static String getText() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return input.nextLine();
    }

    public static String getBonus() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return input.nextLine();
    }

    public static int getManual(int limitCount) {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int manual;

        try {
            manual = Integer.parseInt(input.nextLine());
            System.out.println();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("숫자 정보가 올바르지 않습니다.");
        }

        if (manual > limitCount) {
            throw new IllegalArgumentException("구입금액으로 살 수 없는 양입니다.");
        }
        return manual;
    }

    public static String[] getManualLottos(int manual) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        String[] manualLottos = new String[manual];
        for (int i = 0; i < manualLottos.length; ++i) {
            manualLottos[i] = input.nextLine();
        }
        System.out.println();
        return manualLottos;
    }
}
