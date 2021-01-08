package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class LottoNumbers {
    public static final int ALLOWED_NUMBER_COUNT = 6;

    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        if (areInvalidLottoNumbers(lottoNumbers)) {
            String message = String.format("Size of lottoNumbers should be %d.",
                    ALLOWED_NUMBER_COUNT);
            throw new IllegalArgumentException(message);
        }

        this.lottoNumbers = Collections.unmodifiableList(lottoNumbers);
    }

    public Stream<LottoNumber> toStream() {
        return lottoNumbers.stream();
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

    public boolean contains(LottoNumber lottonumber) {
        return lottoNumbers.contains(lottonumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers that = (LottoNumbers) o;
        return this.lottoNumbers.containsAll(that.lottoNumbers);
    }
}
