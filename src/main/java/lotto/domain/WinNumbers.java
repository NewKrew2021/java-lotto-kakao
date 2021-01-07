package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class WinNumbers {

    private static final int WIN_NUMBERS_SIZE = 6;

    private final List<LottoNumber> winNumbers;

    public WinNumbers(List<Integer> winNumbers) {
        validateWinNumbers(winNumbers);
        this.winNumbers = new ArrayList<>();
        for (Integer winNum : winNumbers) {
            this.winNumbers.add(new LottoNumber(winNum));
        }
    }

    private void validateWinNumbers(List<Integer> winNumbers) {
        if (!isValidSize(winNumbers)) {
            throw new IllegalArgumentException("당첨 번호는 6개입니다.");
        }
        if (!isUnique(winNumbers)) {
            throw new IllegalArgumentException("당첨 번호는 중복되면 안됩니다.");
        }
    }

    private boolean isValidSize(List<Integer> winNumbers) {
        return winNumbers.size() == WIN_NUMBERS_SIZE;
    }

    private boolean isUnique(List<Integer> winNumbers) {
        return winNumbers.stream().distinct().count() == winNumbers.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinNumbers that = (WinNumbers) o;
        return Objects.equals(winNumbers, that.winNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winNumbers);
    }
}
