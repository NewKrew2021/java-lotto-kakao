package lotto;

public class LottoNo {

    int number;

    public LottoNo(Integer number) {
        if( number < 1 || number > 45 ) {
            throw new IllegalArgumentException();
        }

        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNo lottoNo = (LottoNo) o;
        return number == lottoNo.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
