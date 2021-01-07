package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;

public class LottoNos {

    List<LottoNo> numbers = new ArrayList<>();

    public LottoNos(List<Integer> numbers) {
        if( numbers.size() != 6 ) {
            throw new IllegalArgumentException();
        }

        if(checkDuplication(numbers)){
            throw new IllegalArgumentException();
        }

        for( int number : numbers ) {
            this.numbers.add(new LottoNo(number));
        }
    }

    private boolean checkDuplication(List<Integer> numbers){
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < numbers.size(); i++) {
            set.add(numbers.get(i));
        }
        if(set.size() != numbers.size())
            return true;
        return false;
    }

    public boolean isContains(LottoNo lottoNo) {
        return this.numbers.contains(lottoNo);
    }

}
