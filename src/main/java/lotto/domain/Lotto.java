package lotto.domain;

import lotto.util.LottoNumberGenerator;
import lotto.util.RandomNumberGenerator;

import java.util.*;

public class Lotto {
    private static final int LOTTO_PRICE = 1000;
    private Set<LottoNumber> lottoNumbers;

    public Lotto(LottoNumberGenerator lottoNumberGenerator) {
        lottoNumbers = new LinkedHashSet<>();
        for (int l : lottoNumberGenerator.getNumbers()) {
            lottoNumbers.add(LottoNumber.of(l));
        }
    }

    public Lotto() {
        this(new RandomNumberGenerator());
    }

    public Lotto(Set<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
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
