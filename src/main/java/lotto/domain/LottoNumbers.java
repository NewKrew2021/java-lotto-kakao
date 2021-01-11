package lotto.domain;

import lotto.domain.vo.LottoNumber;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {
    public static final int ALLOWED_NUMBER_COUNT = 6;

    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        if (areInvalidLottoNumbers(lottoNumbers)) {
            throw new IllegalArgumentException(String.format("Size of lottoNumbers should be %d.",
                    ALLOWED_NUMBER_COUNT));
        }

        Collections.sort(lottoNumbers);
        this.lottoNumbers = Collections.unmodifiableList(lottoNumbers);
    }

    public List<Integer> getNumbersInTicket() {
        return lottoNumbers.stream()
                .map(LottoNumber::getNumber)
                .collect(Collectors.toList());
    }

    public int getMatchCount(LottoNumbers luckyNumbers) {
        int count = 0;

        for (LottoNumber lottoNumber : lottoNumbers) {
            if (luckyNumbers.contains(lottoNumber)) {
                count++;
            }
        }

        return count;
    }

    public boolean isMatchBonus(LottoNumber bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }

    public boolean contains(LottoNumber lottonumber) {
        return lottoNumbers.contains(lottonumber);
    }

    private boolean areInvalidLottoNumbers(List<LottoNumber> lottoNumbers) {
        return isInvalidSize(lottoNumbers) || !areAllDistinctNumbers(lottoNumbers);
    }

    private boolean isInvalidSize(List<LottoNumber> lottoNumbers) {
        return lottoNumbers.size() != ALLOWED_NUMBER_COUNT;
    }

    private boolean areAllDistinctNumbers(List<LottoNumber> lottoNumbers) {
        return lottoNumbers.stream()
                .distinct()
                .count() == lottoNumbers.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers that = (LottoNumbers) o;
        return this.lottoNumbers.containsAll(that.lottoNumbers);
    }
}
