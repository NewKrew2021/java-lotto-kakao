package view;

import lotto.Lotto;
import lotto.LottoNumber;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int readMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public static Lotto readWinningLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String input = scanner.nextLine();
        List<Integer> winningNumbers = Arrays.stream(input.split(", "))
                .map(Integer::valueOf)
                .collect(Collectors.toList());

        return Lotto.generateLotto(winningNumbers);
    }

    public static LottoNumber readBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusNumber = Integer.parseInt(scanner.nextLine());

        return LottoNumber.getInstance(bonusNumber);
    }
}
