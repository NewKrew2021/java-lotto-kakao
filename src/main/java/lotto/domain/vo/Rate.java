package lotto.domain.vo;

public class Rate {
    private final int rate;

    public Rate(int rate) {
        this.rate = rate;
    }

    public int getRate() {
        return rate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rate that = (Rate) o;
        return this.rate == that.rate;
    }
}
