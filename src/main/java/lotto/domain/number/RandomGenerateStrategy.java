package lotto.domain.number;

import lotto.domain.number.NumberGenerateStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.domain.number.LottoNumbers.LOTTO_TICKET_LENGTH;

public class RandomGenerateStrategy implements NumberGenerateStrategy {

    private static final int MAX_NUMBER_RANGE = 45;
    private static final int MIN_NUMBER_RANGE = 1;

    private static class GenerateNumberCache{
        private static final List<Integer> cache = new ArrayList<>();

        static {
            for (int i = MIN_NUMBER_RANGE; i <= MAX_NUMBER_RANGE; i++) {
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
