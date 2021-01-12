package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LottoInputView {

  private LottoInputView() {
  }

  private static Scanner sc = new Scanner(System.in);

  public static int inputAmount() {
    System.out.println("구입금액을 입력해 주세요.");
    return Integer.parseInt(sc.nextLine());
  }

  public static int inputManualCount() {
    System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
    return Integer.parseInt(sc.nextLine());
  }

  public static List<String> inputManualLottoNumbers(int manualCount) {
    List<String> manualLottoNumbers = new ArrayList<>();
    System.out.println("수동으로 구매할 번호를 입력해주세요.");
    for (int i = 0; i < manualCount; i++) {
      manualLottoNumbers.add(sc.nextLine());
    }

    return manualLottoNumbers;
  }

  public static String inputWinningNumbers() {
    System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    return sc.nextLine();
  }

  public static int inputBonusNumber() {
    System.out.println("보너스 볼을 입력해 주세요.");
    return sc.nextInt();
  }
}
