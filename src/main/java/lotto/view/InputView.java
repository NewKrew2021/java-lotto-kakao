package lotto.view;

import lotto.domain.dto.WinningNumbers;
import lotto.domain.dto.InsertPrice;
import lotto.domain.dto.LottoNumber;
import lotto.domain.LottoNumbers;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class InputView {
    private final static Scanner SC = new Scanner(System.in);

    public InsertPrice scanInsertPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        return new InsertPrice(Integer.parseInt(SC.nextLine().trim()));
    }

    public WinningNumbers scanWinningNumbers() {
        LottoNumbers luckyNumbers = scanLuckyNumbers();
        LottoNumber bonusNumber = scanBonusNumber();

        return new WinningNumbers(luckyNumbers, bonusNumber);
    }

    private LottoNumbers scanLuckyNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        return new LottoNumbers(parseToIntegers(SC.nextLine())
                .stream()
                .map(LottoNumber::valueOf)
                .collect(Collectors.toList()));
    }

    private LottoNumber scanBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return LottoNumber.valueOf(Integer.parseInt(SC.nextLine().trim()));
    }

    private List<Integer> parseToIntegers(String input) {
        return Stream.of(input.split(","))
                .map(value -> Integer.parseInt(value.trim()))
                .collect(Collectors.toList());
    }
}
