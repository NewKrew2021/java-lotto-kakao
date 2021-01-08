package lotto.domain;

import lotto.util.LottoNumberGenerator;
import lotto.util.RandomNumberGenerator;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    private Set<LottoNumber> lottoNumbers;
    private static final int LOTTO_PRICE = 1000;

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

    public boolean isContain(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    @Override
    public String toString() {
        return "[" + lottoNumbers.stream().map(LottoNumber::getNumber)
                .map(no -> Integer.toString(no))
                .collect(Collectors.joining(", ")) + "]";
    }

    public Rank matchLottoRank(Lotto lotto, LottoNumber bonusNumber) {
        return Rank.checkRank((int) lottoNumbers
                .stream()
                .filter(lottoNumber -> lotto.isContain(lottoNumber))
                .count(), lotto.isContain(bonusNumber));
    }

    public static int getLottoPrice() {
        return LOTTO_PRICE;
    }
}
