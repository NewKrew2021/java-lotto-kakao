package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoRandomGenerator implements NumberGenerateStrategy {

    private static final List<Integer> randomNumbers;

    static {
        randomNumbers = new ArrayList<>();
        for (int i = LottoNumber.LOWER_BOUND; i <= LottoNumber.UPPER_BOUND; i++) {
            randomNumbers.add(i);
        }
    }

    @Override
    public Lotto generate() {
        Collections.shuffle(randomNumbers);
        List<LottoNumber> numbers = new ArrayList<>();
        for (int i = 0; i < Lotto.LOTTO_NUMBERS_LENGTH; i++) {
            numbers.add(new LottoNumber(randomNumbers.get(i)));
        }

        Collections.sort(numbers);

        return Lotto.ofLottoNumber(numbers);
    }

}
