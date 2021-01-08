package lotto.view;

import lotto.domain.WinningNumbers;
import lotto.domain.dto.InsertPrice;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class InputView {
    private final int INVALID_INPUT = -1;
    private final static Scanner SC = new Scanner(System.in);
    private boolean done;

    public InsertPrice scanInsertPrice() {
        InsertPrice insertPrice;

        do {
            System.out.println("구입금액을 입력해 주세요.");
            insertPrice = tryToCreateInsertPrice(SC.nextLine());
        } while (!done);

        return insertPrice;
    }

    public WinningNumbers scanWinningNumbers() {
        WinningNumbers winningNumbers;

        do {
            LottoNumbers luckyNumbers = scanLuckyNumbers();
            LottoNumber bonusNumber = scanBonusNumber();
            winningNumbers = tryToCreateWinningNumbers(luckyNumbers, bonusNumber);
        } while (!done);

        return winningNumbers;
    }

    private LottoNumbers scanLuckyNumbers() {
        LottoNumbers lottoNumbers;

        do {
            System.out.println("지난 주 당첨 번호를 입력해 주세요.");
            lottoNumbers = tryToCreateLottoNumbers(SC.nextLine());
        } while (!done);

        return lottoNumbers;
    }

    private LottoNumber scanBonusNumber() {
        LottoNumber bonusNumber;

        System.out.println("보너스 볼을 입력해 주세요.");
        bonusNumber = tryToCreateBonusNumber(SC.nextLine());

        return bonusNumber;
    }

    private WinningNumbers tryToCreateWinningNumbers(LottoNumbers luckyNumbers, LottoNumber bonusNumber) {
        WinningNumbers winningNumbers = null;

        done = true;
        try {
            winningNumbers = new WinningNumbers(luckyNumbers, bonusNumber);
        } catch (IllegalArgumentException e) {
            done = false;
        }

        return winningNumbers;
    }

    private InsertPrice tryToCreateInsertPrice(String input) {
        int num = tryToParseInt(input);
        if (!done) {
            return null;
        }

        InsertPrice insertPrice = null;
        done = true;
        try {
            insertPrice = new InsertPrice(num);
        } catch (IllegalArgumentException e) {
            done = false;
        }

        return insertPrice;
    }

    private LottoNumbers tryToCreateLottoNumbers(String input) {
        LottoNumbers lottoNumbers = null;
        done = true;

        List<Integer> inputNumbers = parseToIntegers(input);
        try {
            lottoNumbers = new LottoNumbers(inputNumbers.stream()
                    .map(LottoNumber::new)
                    .collect(Collectors.toList()));
        } catch (IllegalArgumentException e) {
            done = false;
        }

        return lottoNumbers;
    }

    private LottoNumber tryToCreateBonusNumber(String input) {
        int num = tryToParseInt(input);
        if (!done) {
            return null;
        }

        LottoNumber bonusNumber = null;
        done = true;
        try {
            bonusNumber = new LottoNumber(num);
        } catch (IllegalArgumentException e) {
            done = false;
        }

        return bonusNumber;
    }

    private int tryToParseInt(final String value) {
        int num = INVALID_INPUT;
        done = true;

        try {
            num = Integer.parseInt(value.trim());
        } catch (NumberFormatException ignored) {
            done = false;
        }

        return num;
    }

    private List<Integer> parseToIntegers(String input) {
        return Stream.of(input.split(","))
                .map(String::trim)
                .map(this::tryToParseInt)
                .collect(Collectors.toList());
    }
}
