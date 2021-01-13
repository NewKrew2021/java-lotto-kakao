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
        return (int)userLotto.lotto.stream()
                .filter(lotto::contains)
                .count();
    }

    @Override
    public String toString(){
        StringBuilder str=new StringBuilder();
        str.append('[');
        lotto.stream().forEach(number -> str.append(number.getNumber() + ", "));
        str.delete(str.length()-2, str.length());
        str.append("]\n");
        return str.toString();
    }

}
