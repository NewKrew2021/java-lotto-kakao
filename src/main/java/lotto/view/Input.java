package lotto.view;

import java.util.*;

/*
 * 입력 클래스에서는 입력과 관련된 validation만 체크해주도록 한다.
 * 즉 숫자, 혹은 문자열이 잘 입력 받았는지 부분만 검증해주도록 한다.
 * domain에서 처리할 validation까지 view에서 하지 않도록 한다.
 * (domain에서 처리할 검사의 예: 입력받은 숫자가 특정 범위에 속해있어야 한다거나, 보너스볼은 당첨번호에 포함되어 있어야 한다거나 등의 검증까지는 하지 않는다.)
 * 입력 클래스는 필요한 원시값을 잘 입력받아서 전달해주면 된다.
 */
public class Input {
    private static final Scanner scanner = new Scanner(System.in);

    private Input(){
        throw new IllegalStateException("Input class is not allowed to construct.");
    }

    public static int getPriceFromUser() { //TODO: 사용자가 잘못된 값을 입력했을때 예외처리가 필요하다.
        System.out.println("구입금액을 입력해 주세요.");
        return CustomTypeCasting.stringToInteger(scanner.nextLine());
    }

    public static List<Integer> getWinnerNumbersFromUser(boolean retry) {
        if(retry){
            System.out.println("잘못된 입력입니다. 재시도 합니다.......");
        }
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return CustomTypeCasting.stringToIntegersUsingParsing(scanner.nextLine(), ",");
    }

    public static int getBonusBallFromUser() {
        System.out.println("보너스 볼을 입력해주세요.");
        return CustomTypeCasting.stringToInteger(scanner.nextLine());
    }

    public static int getNumberOfManualTicket() {
        System.out.println("\n수동으로 구매할 로또 수를 입력해 주세요");
        return CustomTypeCasting.stringToInteger(scanner.nextLine());
    }

    public static List<Set<Integer>> getListOfTicketNumbersFromUser(int numberOfTicket) {
        System.out.println("\n수동으로 구매할 번호를 입력해 주세요.");
        List<Set<Integer>> userInputData = new ArrayList<>();
        for(int i = 0; i < numberOfTicket; i++){
            userInputData.add(getTicketNumbersFromUser());
        }
        return userInputData;
    }

    private static Set<Integer> getTicketNumbersFromUser(){
        String userInputTicketNumbers = scanner.nextLine();
        List<Integer> convertedNumbers = CustomTypeCasting.stringToIntegersUsingParsing(userInputTicketNumbers, ",");
        return new HashSet<>(convertedNumbers);
    }
}
