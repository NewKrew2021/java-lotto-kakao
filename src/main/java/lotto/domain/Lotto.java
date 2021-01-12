package lotto.domain;

import java.util.*;

public class Lotto {

    private SortedSet<LottoNumber> lotto;

    public Lotto(SortedSet<LottoNumber> lotto) {
        this.lotto = lotto;
    }

    public final SortedSet<LottoNumber> getLotto(){
        return new TreeSet<>(lotto);
    }

    public int checkSameCount(Lotto userLotto){
        int count = 0;
        for (LottoNumber number : userLotto.lotto) {
            count += lotto.contains(number) ? 1 : 0;
        }

        return count;
    }

    @Override
    public String toString(){
        StringBuilder str=new StringBuilder();
        str.append('[');
        lotto.stream().forEach(number -> str.append(number + ", "));
        str.delete(str.length()-2, str.length());
        str.append("]\n");
        return str.toString();
    }

}
