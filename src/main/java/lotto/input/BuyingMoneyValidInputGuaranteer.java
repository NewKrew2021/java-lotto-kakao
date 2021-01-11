package lotto.input;

import lotto.domain.LottoMoney;

public class BuyingMoneyValidInputGuaranteer extends ValidInputGuaranteer{

    @Override
    protected String getComment(){
        return "구입 금액을 입력해 주세요";
    }

    @Override
    protected void checkValid(String input){
        new LottoMoney(Integer.parseInt(input));
    }
}
