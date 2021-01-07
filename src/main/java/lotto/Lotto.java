package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
public class Lotto {

    private List<Integer> lotto;

    public Lotto(List<Integer> lotto) {

        this.lotto = lotto;
    }

    public List<Integer> getLotto(){

        return lotto;
    }

    public int checkSameCount(Lotto userLotto){
        int count = 0;
        for (Integer number : userLotto.getLotto()) {
            count += lotto.contains(number) ? 1 : 0;
        }

        return count;
    }

    @Override
    public String toString(){
        StringBuilder str=new StringBuilder();
        str.append('[');
        for (int i=0;i<lotto.size()-1;i++) {
            str.append(lotto.get(i)+", ");
        }
        str.append(lotto.get(lotto.size()-1));

//        str.append(lotto.stream().map(integer ->toString()).collect(Collectors.joining(", ")));
        str.append("]\n");
        return str.toString();
    }

}
