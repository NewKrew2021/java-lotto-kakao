package lotto.domain;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final int LOWER_BOUND = 1;
    public static final int UPPER_BOUND = 45;
    private final int number;

    public LottoNumber(int number) {
        if (!isInRange(number)) {
            String message = String.format("Number should be between %d~%d.",
                    LOWER_BOUND,
                    UPPER_BOUND);
            throw new IllegalArgumentException(message);
        }

        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    private boolean isInRange(int number) {
        return LOWER_BOUND <= number && number <= UPPER_BOUND;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return this.number == that.number;
    }

    @Override
    public int hashCode() {
        return this.number;
    }

    @Override
    public int compareTo(LottoNumber o) {
        return number - o.number;
    }
}
