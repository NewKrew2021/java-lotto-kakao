package lotto;

import java.util.List;

public class WinningLottoNos {

    private LottoNos lottoNos;
    private LottoNo bonusNo;

    public WinningLottoNos( List<Integer> numbers, int bonusNo ) {

        this.lottoNos = new LottoNos(numbers);
        this.bonusNo = new LottoNo(bonusNo);

        if ( this.lottoNos.isContains(this.bonusNo) ) {
            throw new IllegalArgumentException();
        }

    }
}
