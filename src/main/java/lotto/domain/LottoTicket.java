package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.HashSet;
import java.util.stream.Collectors;

public class LottoTicket {

    public static final int LOTTO_NUMBER_COUNT_OF_TICKET = 6;
    public static final int LOTTO_PRICE = 1000;

    List<LottoNo> numbers = new ArrayList<>();

    public LottoTicket(List<Integer> numbers) {

        if( !checkValidationLottoTicket(numbers) ) {
            throw new IllegalArgumentException();
        }

        Collections.sort(numbers);
        for( int number : numbers ) {
            this.numbers.add(new LottoNo(number));
        }
    }

    public static boolean checkValidationLottoTicket(List<Integer> numbers) {
        if( numbers.size() != LOTTO_NUMBER_COUNT_OF_TICKET ) {
            return false;
        }

        if(checkDuplication(numbers)){
            return false;
        }

        return true;
    }

    private static boolean checkDuplication(List<Integer> numbers){
        HashSet<Integer> set = new HashSet<>(numbers);
        return set.size() != numbers.size();
    }

    public boolean isContains(LottoNo lottoNo) {
        return this.numbers.contains(lottoNo);
    }

    public int matchTickets(LottoTicket lottoTicket) {
        return (int) this.numbers.stream()
                .filter(lottoTicket::isContains)
                .count();
    }

    @Override
    public String toString() {
        return this.numbers.toString();
    }
}
