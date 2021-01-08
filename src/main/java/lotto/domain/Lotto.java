package lotto.domain;

import lotto.util.LottoNumberGenerator;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Lotto {
    private Set<LottoNumber> lottoNumbers;

    public Lotto(LottoNumberGenerator lottoNumberGenerator) {
        lottoNumbers = new TreeSet<>(new Comparator<LottoNumber>() {
            @Override
            public int compare(LottoNumber o1, LottoNumber o2) {
                return o1.getNumber() - o2.getNumber();
            }
        });
        for (int l : lottoNumberGenerator.getNumbers()) {
            lottoNumbers.add(LottoNumber.of(l));
        }
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
}
