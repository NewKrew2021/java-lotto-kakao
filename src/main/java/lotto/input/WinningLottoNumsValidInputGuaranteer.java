package lotto.input;

import lotto.domain.LottoNumbers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLottoNumsValidInputGuaranteer extends ValidInputGuaranteer<LottoNumbers>{
    @Override
    protected String getComment(){
        return "지난 주 당첨 번호를 입력해 주세요.";
    }

    @Override
    public LottoNumbers transformToObject(String input){
        List<Integer> lottoNumbers = Arrays.asList(input.split(","))
                .stream()
                .map((String ballNumberInput) -> ballNumberInput.trim())
                .map((String ballNumber) -> Integer.parseInt(ballNumber))
                .collect(Collectors.toList());
        return new LottoNumbers(lottoNumbers);
    }
}
