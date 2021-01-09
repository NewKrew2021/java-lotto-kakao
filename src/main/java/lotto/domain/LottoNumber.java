package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

    private final int lottoNumber;

    private LottoNumber(int lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    private static class LottoNumberFactory {
        private static final Map<Integer, LottoNumber> lottoNumberBox = new HashMap<>();

        private static LottoNumber getLottoNumber(int lottoNumber) {
            lottoNumberBox.putIfAbsent(lottoNumber, new LottoNumber(lottoNumber));
            return lottoNumberBox.get(lottoNumber);
        }
    }

    public static LottoNumber valueOf(String lottoNumberString) {
        int lottoNumber = checkInteger(lottoNumberString);
        checkRange(lottoNumber);
        return LottoNumberFactory.getLottoNumber(lottoNumber);
    }

    private static int checkInteger(String lottoNumberString) {
        int lottoNumber = 0;
        try {
            lottoNumber = Integer.parseInt(lottoNumberString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("볼은 정수여야 한다.");
        }
        return lottoNumber;
    }

    private static void checkRange(int lottoNumber) {
        if (outOfRange(lottoNumber)) {
            throw new IllegalArgumentException("볼은 1 이상 45 이하여야 한다.");
        }
    }

    private static boolean outOfRange(int lottoNumber) {
        return 1 > lottoNumber || lottoNumber > 45;
    }
    
    @Override
    public String toString() {
        return String.valueOf(lottoNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber lottoNumber = (LottoNumber) o;
        return this.lottoNumber == lottoNumber.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }

    @Override
    public int compareTo(LottoNumber o) {
        return this.lottoNumber - o.lottoNumber;
    }
}
