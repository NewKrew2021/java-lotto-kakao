package lotto.input;

import lotto.domain.LottoNo;
import lotto.domain.LottoNos;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BonusNumberValidInputGuaranteer extends ValidInputGuaranteer{
    @Override
    protected String getComment(){
        return "보너스 볼을 입력해 주세요.";
    }

    @Override
    protected void checkValid(String input){
        new LottoNo(Integer.parseInt(input));
    }
}
