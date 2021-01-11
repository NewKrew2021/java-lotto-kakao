package lotto.input;

import lotto.domain.LottoNumber;

public class BonusNumberValidInputGuaranteer extends ValidInputGuaranteer{
    @Override
    protected String getComment(){
        return "보너스 볼을 입력해 주세요.";
    }

    @Override
    protected void checkValid(String input){
        new LottoNumber(Integer.parseInt(input));
    }
}
