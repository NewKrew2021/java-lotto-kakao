package lotto.view;

import java.util.ArrayList;
import java.util.List;

public class CustomTypeCasting { //TODO 이곳에서 예외처리

    private CustomTypeCasting() {
        throw new IllegalStateException("CustomTypeCasting class is not allowed to construct");
    }

    public static int stringToInteger(String string){
        return Integer.parseInt(string);
    }

    /* 전달받은 string을 split한다. 숫자 양옆의 공백문자는 제거된다. */
    public static List<Integer> stringToIntegersUsingParsing(String userInput, String delimiter) {
        List<Integer> userInputNumbers = new ArrayList<>();

        for (String currentFragment : userInput.split(delimiter)) {
            userInputNumbers.add(Integer.parseInt(currentFragment.trim()));
        }

        return userInputNumbers;
    }
}
