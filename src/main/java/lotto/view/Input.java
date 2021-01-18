package lotto.view;

import lotto.exceptions.CastingFailException;
import lotto.exceptions.IllegalTypeEnteredException;

import java.util.*;

public class Input {
    private static final Scanner scanner = new Scanner(System.in);

    private Input() {
        throw new IllegalStateException("Input class is not allowed to construct.");
    }

    public static int getPriceFromUser() {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            return CustomTypeCasting.stringToInteger(scanner.nextLine());
        } catch(CastingFailException e) {
            throw new IllegalTypeEnteredException("구입금액 입력이 정수가 아닙니다.");
        }
    }

    public static List<Integer> getWinnerNumbersFromUser() {
        try {
            System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
            return CustomTypeCasting.stringToIntegersUsingParsing(scanner.nextLine(), ",");
        } catch(CastingFailException e) {
            throw new IllegalTypeEnteredException("지난 주 당첨번호가 잘못된 형식으로 입력되었습니다. (숫자를 ,로 파싱할 수 없습니다.)");
        }
    }

    public static int getBonusBallFromUser() {
        try {
            System.out.println("보너스 볼을 입력해주세요.");
            return CustomTypeCasting.stringToInteger(scanner.nextLine());
        } catch(CastingFailException e) {
            throw new IllegalTypeEnteredException("보너스볼이 정수가 아닙니다.");
        }
    }

    public static int getNumberOfManualTicket() {
        try {
            System.out.println("\n수동으로 구매할 로또 수를 입력해 주세요");
            return CustomTypeCasting.stringToInteger(scanner.nextLine());
        } catch(CastingFailException e) {
            throw new IllegalTypeEnteredException("수동으로 구매할 로또 수가 정수가 아닙니다.");
        }
    }

    public static List<Set<Integer>> getListOfTicketNumbersFromUser(int numberOfTicket) {
        try {
            System.out.println("\n수동으로 구매할 번호를 입력해 주세요.");
            List<Set<Integer>> userInputData = new ArrayList<>();
            for (int i = 0; i < numberOfTicket; i++) {
                userInputData.add(getTicketNumbersFromUser());
            }
            return userInputData;
        } catch(CastingFailException e) {
            throw new IllegalTypeEnteredException("수동으로 구매할 번호가 잘못 입력되었습니다. (숫자를 ,로 파싱할 수 없습니다.)");
        }
    }

    private static Set<Integer> getTicketNumbersFromUser() {
        String userInputTicketNumbers = scanner.nextLine();
        List<Integer> convertedNumbers = CustomTypeCasting.stringToIntegersUsingParsing(userInputTicketNumbers, ",");
        return new HashSet<>(convertedNumbers);
    }
}