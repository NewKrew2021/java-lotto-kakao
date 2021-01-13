package lotto.domain.dto;

import lotto.domain.vo.LottoNumber;

import java.util.List;

public class LottoNumbersDto {
    private final List<LottoNumber> numbers;

    public LottoNumbersDto(List<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    public List<LottoNumber> getNumbers() {
        return numbers;
    }
}
