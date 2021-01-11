package lotto.domain.vo;

public class LottoNumber implements Comparable<LottoNumber> {
    public static final int LOWER_BOUND = 1;
    public static final int UPPER_BOUND = 45;
    private static final LottoNumber[] LOTTONUMBERS_CACHE = new LottoNumber[UPPER_BOUND];
    private final int number;

    static {
        for (int i = LOWER_BOUND; i <= UPPER_BOUND; i++) {
            LOTTONUMBERS_CACHE[i - 1] = new LottoNumber(i);
        }
    }

    private LottoNumber(int number) {
        this.number = number;
    }

    public static LottoNumber valueOf(int number) {
        if (!isInRange(number)) {
            throw new IllegalArgumentException(String.format("Number should be between %d~%d.",
                    LOWER_BOUND,
                    UPPER_BOUND));
        }

        return LOTTONUMBERS_CACHE[number - 1];
    }

    public int getNumber() {
        return number;
    }

    private static boolean isInRange(int number) {
        return LOWER_BOUND <= number && number <= UPPER_BOUND;
    }

    @Override
    public boolean equals(Object o) {
        return this == o;
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
