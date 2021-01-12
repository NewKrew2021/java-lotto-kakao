package lotto.domain.number;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.domain.number.LottoNumber.MAX_LOTTO_NUMBER;
import static lotto.domain.number.LottoNumber.MIN_LOTTO_NUMBER;
import static lotto.domain.number.LottoNumbers.LOTTO_TICKET_LENGTH;

public class RandomGenerateStrategy implements NumberGenerateStrategy {

    private static class GenerateNumberCache {
        private static final List<Integer> cache = new ArrayList<>();

        static {
            for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
                cache.add(i);
            }
        }
    }

    @Override
    public List<Integer> generate() {

        Collections.shuffle(GenerateNumberCache.cache);

        return GenerateNumberCache.cache.subList(0, LOTTO_TICKET_LENGTH);
    }

}
