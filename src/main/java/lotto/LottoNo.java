package lotto;

public class LottoNo {

    int number;

    public LottoNo(Integer number) {
        if( number < 1 || number > 45 ) {
            throw new IllegalArgumentException();
        }

        this.number = number;
    }



}
