package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.LottoNumbers.LOTTO_TICKET_LENGTH;

public class RandomGenerateStrategy implements NumberGenerateStrategy {

    private static final int MAX_NUMBER_RANGE = 45;
    private static final int MIN_NUMBER_RANGE = 1;

    @Override
    public List<Integer> generate() {
        List<Integer> randomNumbers = new ArrayList<>();
        for (int i = MIN_NUMBER_RANGE; i <= MAX_NUMBER_RANGE; i++) {
            randomNumbers.add(i);
        }
        Collections.shuffle(randomNumbers);

        return randomNumbers.subList(0, LOTTO_TICKET_LENGTH);
    }
}
