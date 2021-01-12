package lotto.domain;

import lotto.exception.FailBuyLottoException;
import lotto.exception.NumberErrorException;
import lotto.util.RandomNumberGenerator;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    public static final int LOTTO_PRICE = 1000;
    public static final int LOTTO_NUMBER_LENGTH = 6;
    private Set<LottoNumber> lottoNumbers;

    public Lotto() {
        this(RandomNumberGenerator.getNumbers());
    }

    public Lotto(List<Integer> numbers) {
        lottoNumbers = numbers.stream()
                .map(LottoNumber::of)
                .sorted(Comparator.comparingInt(LottoNumber::getNumber))
                .collect(Collectors.toCollection(LinkedHashSet::new));

        if (!isNorMalNumber()) {
            throw new NumberErrorException();
        }
    }

    private boolean isNorMalNumber() {
        return lottoNumbers.size() == LOTTO_NUMBER_LENGTH;
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    public Set<LottoNumber> getLottoData() {
        return Collections.unmodifiableSet(lottoNumbers);
    }

    public int matchCount(Lotto lotto) {
        return (int) lottoNumbers
                .stream()
                .filter(lotto::contains)
                .count();
    }
}
