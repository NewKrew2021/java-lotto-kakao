package lotto.view;

import java.util.ArrayList;
import java.util.List;

public class CustomTypeCasting {

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
