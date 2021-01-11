package lotto.domain;

import lotto.exception.HasDuplicateNumberException;
import lotto.util.LottoNumberGenerator;
import lotto.util.RandomNumberGenerator;

import java.util.*;

public class Lotto {
    private static final int LOTTO_PRICE = 1000;
    public static final int LOTTO_NUMBER_LENGTH = 6;
    private Set<LottoNumber> lottoNumbers;

    public Lotto(LottoNumberGenerator lottoNumberGenerator) {
        this(lottoNumberGenerator.getNumbers());
    }

    public Lotto() {
        this(new RandomNumberGenerator());
    }

    public Lotto(List<Integer> numbers) {
        lottoNumbers = new LinkedHashSet<>();
        for (Integer number : numbers) {
            lottoNumbers.add(LottoNumber.of(number));
        }
        if(isDuplicateNumber()){
            throw new HasDuplicateNumberException();
        }
    }

    private boolean isDuplicateNumber() {
        return lottoNumbers.size() < LOTTO_NUMBER_LENGTH;
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    public LottoDto getLottoData() {
        return new LottoDto(Collections.unmodifiableSet(lottoNumbers));
    }

    public int matchCount(Lotto lotto) {
        return (int) lottoNumbers
                .stream()
                .filter(lotto::contains)
                .count();
    }

    public static int getLottoPrice() {
        return LOTTO_PRICE;
    }
}
