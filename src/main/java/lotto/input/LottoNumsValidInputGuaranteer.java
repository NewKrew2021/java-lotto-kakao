package lotto.input;

import lotto.domain.LottoNumbers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumsValidInputGuaranteer extends ValidInputGuaranteer<LottoNumbers>{
    @Override
    protected String getComment(){
        return "";
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
