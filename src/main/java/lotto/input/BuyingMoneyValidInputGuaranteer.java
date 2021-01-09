package lotto.input;

import lotto.Constant;

public class BuyingMoneyValidInputGuaranteer extends ValidInputGuaranteer{

    @Override
    protected String getComment(){
        return "구입 금액을 입력해 주세요";
    }

    @Override
    protected void checkValid(String input){
        int count = Integer.parseInt(input) / Constant.LOTTO_PRICE;
        if(count <= 0)
            throw new IllegalArgumentException("구입금액을 잘못 입력하셨습니다. 다시 입력해주세요.");
    }
}
