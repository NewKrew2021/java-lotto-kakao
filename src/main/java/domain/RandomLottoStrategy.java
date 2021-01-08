package domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLottoStrategy implements LottoStrategy {

    private final List<Integer> lottoNumbers;

    public RandomLottoStrategy() {
        lottoNumbers = IntStream.
                rangeClosed(LottoNumber.START_LOTTO_NUMBER, LottoNumber.END_LOTTO_NUMBER)
                .boxed()
                .collect(Collectors.toList());
    }

    @Override
    public List<Integer> numberChooseStrategy() {
        Collections.shuffle(lottoNumbers);
        List<Integer> result = lottoNumbers.stream()
                .limit(Lotto.LOTTO_NUMBER_SIZE)
                .collect(Collectors.toList());
        Collections.sort(result);
        return result;
    }

}
