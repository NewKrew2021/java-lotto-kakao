package lotto.view;

import lotto.domain.Ticket;
import lotto.domain.WinnerBalls;
import lotto.utils.Utils;

import java.util.*;

public class Input {
    private static Scanner scanner = new Scanner(System.in);

    public static int getPriceFromUser(){
        System.out.println("구입금액을 입력해 주세요.");
        int inputMoney = scanner.nextInt(); scanner.nextLine();
        return inputMoney;
    }

    public static WinnerBalls getWinnerBallsFromUser() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String userInput = scanner.nextLine();

        List<Integer> userInputNumbers = Utils.extractIntFrom(userInput, ",");

        System.out.println("보너스 볼을 입력해주세요.");
        int ball = scanner.nextInt();

        // TODO : 여기서도 입력된 값에 대한 유효성 검사를 해줘야 한다. (지금은 만들지 않았다.)
        // ticket의 data, 보너스볼 데이터 등은 generator에서 생성하기도 하고,
        // 사용자로부터 생성되기도 한다. 그래서 유효성 검사에 대한 코드를 양쪽에 구현해야 한다.
        // 유효성을 검사해주는 부분을 하나의 클래스에서 담당하고, 기능을 제공해보자.
        return new WinnerBalls(new Ticket(new HashSet<>(userInputNumbers)), ball);
    }
}
