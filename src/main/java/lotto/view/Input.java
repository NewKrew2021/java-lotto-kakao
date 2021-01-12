package lotto.view;

import lotto.domain.Ticket;
import lotto.domain.WinnerBalls;
import lotto.setting.Format;

import java.util.*;

public class Input {
    private static final Scanner scanner = new Scanner(System.in);

    public static int getPriceFromUser() {
        System.out.println("구입금액을 입력해 주세요.");
        return CustomTypeCasting.stringToInteger(scanner.nextLine());
    }

    public static List<Integer> getWinnerNumbersFromUser() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return CustomTypeCasting.stringToIntegersUsingParsing(scanner.nextLine(), ",");
    }

    public static int getBonusBallFromUser(){
        System.out.println("보너스 볼을 입력해주세요.");
        int ball = CustomTypeCasting.stringToInteger(scanner.nextLine());
        return ball;
    }

    /* 이 기능을 다른 클래스로 이동시킬지 고민했었는데, UI에 따라서 입력형식이 달라지므로, 이 클래스에 놓는게 좋다고 생각했습니다. */
    private static WinnerBalls validationCheckAndWrap(List<Integer> userInputNumbers, int bonusBall) {
        Format.validateTicketSizeOf(userInputNumbers.size());

        Set<Integer> extractedUserInputNumbers = new HashSet<>(userInputNumbers);
        Format.validateTicketSizeOf(extractedUserInputNumbers.size());

        Format.validateNumberRangeOf(extractedUserInputNumbers);
        Format.validateBonusBall(extractedUserInputNumbers, bonusBall);

        return new WinnerBalls(new Ticket(extractedUserInputNumbers), bonusBall);
    }
}
