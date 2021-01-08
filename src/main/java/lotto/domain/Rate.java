package lotto.domain;

public class Rate {
    private final int rate;

    public Rate(int rate) {
        if (isNegative(rate)) {
            String message = "rate cannot be negative";
            throw new IllegalArgumentException(message);
        }
        this.rate = rate;
    }

    public int getRate() {
        return rate;
    }

    private boolean isNegative(int rate) {
        return rate < 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rate that = (Rate) o;
        return this.rate == that.rate;
    }
}
