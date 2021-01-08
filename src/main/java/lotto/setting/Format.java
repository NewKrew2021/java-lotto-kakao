package lotto.setting;

import java.util.Set;

public class Format {
    public static final int TICKET_PRICE = 1000;
    public static final int TICKET_SIZE = 6;
    public static final int LOWER_LIMIT_OF_NUMBER = 1;
    public static final int UPPER_LIMIT_OF_NUMBER = 45;

    public static void validateTicketSizeOf(int testTicketSize){
        if(TICKET_SIZE != testTicketSize){
            throw new RuntimeException("invalid Ticket size!!");
        }
    }

    public static void validateNumberRangeOf(Set<Integer> numbers){
        for (int number : numbers) {
            rangeCheckForOneNumber(number);
        }
    }

    private static void rangeCheckForOneNumber(int number){
        if(number < LOWER_LIMIT_OF_NUMBER || UPPER_LIMIT_OF_NUMBER < number){
            throw new RuntimeException("contains invalid number value.");
        }
    }
}
