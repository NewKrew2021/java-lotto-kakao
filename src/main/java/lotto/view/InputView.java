package lotto.view;

import lotto.domain.*;
import lotto.domain.vo.LottoNumber;
import lotto.domain.vo.Price;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class InputView {
    private final static Scanner SC = new Scanner(System.in);

    public Price scanPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        return new Price(Integer.parseInt(SC.nextLine().trim()));
    }

    public int scanManualChooseTicketCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return Integer.parseInt(SC.nextLine().trim());
    }

    public LottoTickets scanManualChooseTickets(int count) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        return LottoTicketIssuer.issuing(new ManualPickStrategy(), count);
    }

    public WinningNumbers scanWinningNumbers() {
        LottoNumbers luckyNumbers;
        LottoNumber bonusNumber;

        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        luckyNumbers = new LottoNumbers(scanTicket());

        System.out.println("보너스 볼을 입력해 주세요.");
        bonusNumber = LottoNumber.valueOf(scanNumber());

        return new WinningNumbers(luckyNumbers, bonusNumber);
    }

    public List<LottoNumber> scanTicket() {
        return parseToIntegers(SC.nextLine())
                .stream()
                .map(LottoNumber::valueOf)
                .collect(Collectors.toList());
    }

    private int scanNumber() {
        return Integer.parseInt(SC.nextLine().trim());
    }

    private List<Integer> parseToIntegers(String input) {
        return Stream.of(input.split(","))
                .map(value -> Integer.parseInt(value.trim()))
                .collect(Collectors.toList());
    }
}
