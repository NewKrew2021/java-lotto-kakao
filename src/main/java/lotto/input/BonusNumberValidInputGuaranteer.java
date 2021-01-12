package lotto.input;

import lotto.domain.LottoNumber;

public class BonusNumberValidInputGuaranteer extends ValidInputGuaranteer<LottoNumber>{
    @Override
    protected String getComment(){
        return "보너스 볼을 입력해 주세요.";
    }

    @Override
    public LottoNumber transformToObject(String input){
        return new LottoNumber(Integer.parseInt(input));
    }
}
