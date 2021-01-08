package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.HashSet;
import java.util.stream.Collectors;

public class LottoTicket {

    private static final int LOTTO_NUMBER_COUNT_OF_TICKET = 6;
    List<LottoNo> numbers = new ArrayList<>();

    public LottoTicket(List<Integer> numbers) {
        if( numbers.size() != LOTTO_NUMBER_COUNT_OF_TICKET ) {
            throw new IllegalArgumentException();
        }

        if(checkDuplication(numbers)){
            throw new IllegalArgumentException();
        }

        Collections.sort(numbers);
        for( int number : numbers ) {
            this.numbers.add(new LottoNo(number));
        }
    }

    private boolean checkDuplication(List<Integer> numbers){
        HashSet<Integer> set = new HashSet<>(numbers);
        return set.size() != numbers.size();
    }

    public boolean isContains(LottoNo lottoNo) {
        return this.numbers.contains(lottoNo);
    }

    public int getMatchCount(LottoTicket lottoTicket) {
        return (int) this.numbers.stream()
                .filter(lottoTicket::isContains)
                .count();
    }

    @Override
    public String toString() {
        return this.numbers.toString();
    }
}
