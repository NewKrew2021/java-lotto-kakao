package lotto;

import java.util.Objects;

public class LottoNo implements Comparable<LottoNo>{

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

    @Override
    public int compareTo(LottoNo o) {
        if(this.number < o.number)
            return 1;
        if(this.number > o.number)
            return -1;
        return 0;
    }
}
