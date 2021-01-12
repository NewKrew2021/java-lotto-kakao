package lotto.input;

import lotto.domain.LottoMoney;

public class BuyingMoneyValidInputGuaranteer extends ValidInputGuaranteer<LottoMoney>{

    @Override
    protected String getComment(){
        return "구입 금액을 입력해 주세요";
    }

    @Override
    public LottoMoney transformToObject(String input){
        return new LottoMoney(Integer.parseInt(input));
    }
}
