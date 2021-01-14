package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

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
        lotto.stream()
                .map(LottoNumber::getNumber)
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        str.append("]\n");
        return str.toString();
    }

}
