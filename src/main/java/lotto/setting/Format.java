package lotto.setting;

import java.util.Set;

public class Format {
    public static final int TICKET_PRICE = 1000;

    public static void validateBonusBall(Set<Integer> numbers, int x) {
        if(numbers.contains(x)){
            throw new RuntimeException("bonusBall number already included.");
        }
    }
}
