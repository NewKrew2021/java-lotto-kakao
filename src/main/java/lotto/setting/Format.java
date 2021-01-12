package lotto.setting;

import java.util.Set;

public class Format {
    public static final int LOWER_LIMIT_OF_NUMBER = 1;
    public static final int UPPER_LIMIT_OF_NUMBER = 45;
    public static final int TICKET_PRICE = 1000;

    public static void validateBonusBall(Set<Integer> numbers, int x) {
        if(numbers.contains(x)){
            throw new RuntimeException("bonusBall number already included.");
        }
    }
}
