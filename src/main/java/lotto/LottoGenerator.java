package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LottoGenerator {

    public Lotto generateLotto() {

        List<Integer> lotto = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        while (set.size() < 6) {
            checkDuplicate(set, RandomUtil.getRandomValue(), lotto);
        }
        return new Lotto(lotto);
    }

    public void checkDuplicate(HashSet<Integer> set, int randomNumber, List<Integer> lotto) {
        if (set.add(randomNumber)) {
            lotto.add(randomNumber);
        }

    }


}
