package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private List<Integer> lotto;

    public Lotto(List<Integer> lotto) {
        if (lotto.size() != 6) {
            throw new IllegalArgumentException("6자리 숫자가 아닙니다.");
        }
        this.lotto = lotto;
    }

    public List<Integer> getLotto() {

        return lotto;
    }

    public int checkSameCount(Lotto userLotto) {

        int count = 0;
        for (Integer number : userLotto.getLotto()) {
            count += lotto.contains(number) ? 1 : 0;
        }

        return count;
    }

    @Override
    public String toString() {

        StringBuilder str = new StringBuilder();
        str.append('[');
        str.append(lotto.stream().map(Object::toString).collect(Collectors.joining(", ")));
        str.append("]\n");
        return str.toString();
    }

}
