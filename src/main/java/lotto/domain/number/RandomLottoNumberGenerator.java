package lotto.domain.number;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.domain.number.LottoNumber.MAX_LOTTO_NUMBER;
import static lotto.domain.number.LottoNumber.MIN_LOTTO_NUMBER;
import static lotto.domain.number.LottoNumbers.LOTTO_TICKET_LENGTH;

public class RandomLottoNumberGenerator implements NumberGenerateStrategy {

    private static final int FIRST_INDEX = 0;

    private final List<Integer> lottoNumberPools;

    private RandomLottoNumberGenerator(List<Integer> lottoNumberPools) {
        this.lottoNumberPools = Collections.synchronizedList(lottoNumberPools);
    }

    public static RandomLottoNumberGenerator initialize() {
        List<Integer> randomNumbers = new ArrayList<>();
        for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
            randomNumbers.add(i);
        }

        return new RandomLottoNumberGenerator(randomNumbers);
    }

    @Override
    public List<Integer> generate() {
        Collections.shuffle(lottoNumberPools);
        return lottoNumberPools.subList(FIRST_INDEX, LOTTO_TICKET_LENGTH);
    }
}
