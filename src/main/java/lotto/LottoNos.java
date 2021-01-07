package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoNos {

    List<LottoNo> numbers = new ArrayList<>();

    public LottoNos(List<Integer> numbers) {

        if( numbers.size() != 6 ) {
            throw new IllegalArgumentException();
        }

        for( int number : numbers ) {
            this.numbers.add(new LottoNo(number));
        }

    }

}
