package lotto.domain.number;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.domain.number.LottoNumber.MAX_LOTTO_NUMBER;
import static lotto.domain.number.LottoNumber.MIN_LOTTO_NUMBER;
import static lotto.domain.number.LottoNumbers.LOTTO_TICKET_LENGTH;

public class RandomLottoNumberGenerator implements NumberGenerateStrategy {

    private static final int FIRST_INDEX = 0;

    @Override
    public List<Integer> generate() {
        List<Integer> randomNumbers = new ArrayList<>();
        for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
            randomNumbers.add(i);
        }
        Collections.shuffle(randomNumbers);

        return randomNumbers.subList(FIRST_INDEX, LOTTO_TICKET_LENGTH);
    }
}
