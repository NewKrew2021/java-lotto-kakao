package lotto.dto;

import lotto.domain.LottoNumber;

public class LottoNumberDto {
    private int number;

    private LottoNumberDto(int number) {
        this.number = number;
    }

    public static LottoNumberDto from(LottoNumber lottoNumber) {
        return new LottoNumberDto(lottoNumber.getNumber());
    }

    public int getNumber() {
        return number;
    }
}
