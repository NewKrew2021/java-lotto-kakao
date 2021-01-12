package lotto.domain;

import java.util.*;

public class LottoTicket {

    public static final int LOTTO_NUMBER_COUNT_OF_TICKET = 6;
    public static final int LOTTO_PRICE = 1000;

    private List<LottoNo> numbers = new ArrayList<>();

    public LottoTicket(Set<Integer> numbers) {

        if( !checkValidationLottoTicket(numbers) ) {
            IllegalArgumentException error = new IllegalArgumentException();
            error.printStackTrace();
            throw error;
        }

        for( int number : numbers ) {
            this.numbers.add(new LottoNo(number));
        }
        Collections.sort(this.numbers);
    }

    public static boolean checkValidationLottoTicket(final Set<Integer> numbers) {
        return numbers.size() == LOTTO_NUMBER_COUNT_OF_TICKET;
    }

    public boolean isContains(LottoNo lottoNo) {
        return this.numbers.contains(lottoNo);
    }

    @Override
    public String toString() {
        return this.numbers.toString();
    }
}
